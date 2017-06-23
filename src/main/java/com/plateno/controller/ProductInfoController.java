package com.plateno.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plateno.common.observer.ConcreteObserver;
import com.plateno.common.observer.Subject;
import com.plateno.common.pager.Pager;
import com.plateno.dao.model.ProductInfo;
import com.plateno.pojo.ProductInfoQueryVo;
import com.plateno.service.ProductInfoService;

@Controller
@RequestMapping("/product")
public class ProductInfoController extends Subject{
	
	@Autowired
	private ProductInfoService productInfoService;
	private static final Logger logger=LoggerFactory.getLogger(ProductInfoController.class);	
	
	public ProductInfoController(){
		ConcreteObserver observer=new ConcreteObserver();
		super.addObserver(observer);//设置观察者对象
	}
		
	
	/**
	 * 分页搜索
	 * @param model
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/search")
	public String pageSearch(Model model,ProductInfoQueryVo condition){
		try {
			if(null==condition){
				condition=new ProductInfoQueryVo();
			}
			condition.setStartIndex(condition.getPageSize()*(condition.getPageNo()-1));
			Pager pager=this.productInfoService.queryProductPagerByCondition(condition);
			model.addAttribute("pager", pager);		
			model.addAttribute("condition", condition);		
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("分页搜索出错啦,请检查："+e.getMessage(),e);
		}		
		return "/product/product";
	}
	
	/**
	 * 商品预添加
	 * @return
	 */
	@RequestMapping(value="/preAdd")
	public String preAddProductInfo(){
		return "/product/productAdd";
	}
	
	/**
	 * 保存商品信息
	 * @param model
	 * @param productInfo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProductInfo(Model model,ProductInfo productInfo){
		try {
			int result=this.productInfoService.insertProductInfo(productInfo);
			if(result!=0){
				logger.info("添加商品信息成功");
				super.noitifyObserver("日志logger：新增商品信息~");
			}else{
				logger.error("添加商品失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("添加商品出错啦，请检查："+e.getMessage(),e);
		}
		return pageSearch(model,null);
	}
	
	/**
	 * 商品预修改
	 * @param model
	 * @param proId
	 * @return
	 */
	@RequestMapping(value="/preUpdate")
	public String preUpdateProductInfo(Model model,String proId){
		try {
			if(StringUtils.isNotBlank(proId)){
				ProductInfo product=this.productInfoService.queryProductInfoById(Integer.valueOf(proId));
				model.addAttribute("product", product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("商品预修改出错啦，请检查："+e.getMessage(),e);
		}
		return "/product/productUpdate";
	}
	
	/**
	 * 商品信息修改
	 * @param model
	 * @param productInfo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateProductInfo(Model model,ProductInfo productInfo){
		try {
			int cnt=this.productInfoService.updateProductInfo(productInfo);
			if(cnt!=0){
				logger.info("商品信息修改成功");
				super.noitifyObserver("日志logger：修改了商品（"+productInfo.getpName()+"）的信息~");
			}else{
				logger.error("商品信息修改失败");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("商品信息修改出错啦，请检查："+e.getMessage(),e);
		}
		return pageSearch(model,null);
	}
	
	/**
	 * 删除商品信息
	 * @param model
	 * @param proId
	 * @return
	 */
	@RequestMapping(value="/delete")
	public String deleteProductInfo(Model model,String proId){
		try {
			if(StringUtils.isNotBlank(proId)){
				int cnt=this.productInfoService.deleteProductInfo(Integer.valueOf(proId));
				if(cnt!=0){
					logger.info("商品信息删除成功");
					super.noitifyObserver("日志logger：删除了商品id为（"+proId+"）的商品信息~");
				}else{
					logger.error("商品信息删除失败");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("商品信息删除出错啦,请检查："+e.getMessage(),e);
		}
		return pageSearch(model,null);
	}

}
