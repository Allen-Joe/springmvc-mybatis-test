package com.plateno.common.tag;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FormExportTag extends TagSupport{

	private static final long serialVersionUID = -1839163482296906768L;
	private String formName;
	@SuppressWarnings("rawtypes")
	private List formColumnTexts;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		String templateFileUrl = "E:/exportTemplate/商品信息导出模版.xls";
		Map beans = new HashMap();
        beans.put("comFormExportVos", formColumnTexts);
        
        //准备输出流
        OutputStream os=null;
        FileInputStream is=null;
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        try{
        	response.setCharacterEncoding("UTF-8");
        	response.setContentType("application/vnd.ms-excel");
        	response.setHeader("Content-disposition",
                    "attachment;success=true;filename="
                            + URLEncoder.encode(this.formName, "utf-8")+".xls");
        	os=response.getOutputStream();
	        XLSTransformer transformer = new XLSTransformer();
	        try {
				//获取Excel模板输入流
				is=new FileInputStream(templateFileUrl);
				//将beans通过模板输入流写到workbook中
				Workbook workbook=transformer.transformXLS(is, beans);
				 //将workbook中的内容用输出流写出去
				workbook.write(os);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}finally{
				is.close();
				os.flush();
			}
        }catch (Exception e) {
			e.printStackTrace();
		
        }
					
		return SKIP_BODY;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public List getFormColumnTexts() {
		return formColumnTexts;
	}

	public void setFormColumnTexts(List formColumnTexts) {
		this.formColumnTexts = formColumnTexts;
	}

	
}
