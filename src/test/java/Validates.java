
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.plateno.common.util.ValidatesUtil;


public class Validates {

    private static boolean validateRegisterMemberParam(){
    	boolean validateFlag=true;
    	String mobile="15820257824";
    	String memberName="试试";
    	String memberSex="男";
    	String IDCard="1";
    	//验证手机号
    	if(org.apache.commons.lang3.StringUtils.isBlank(mobile)||!ValidatesUtil.isMobile(mobile)){
    		System.out.println("手机号不通过");
    		return false;
    	}
    	//验证姓名
    	if(org.apache.commons.lang3.StringUtils.isBlank(memberName)||ValidatesUtil.isContainSpecialChar(memberName)){
    		System.out.println("姓名不通过");
    		return false;
    	}
    	//验证性别
    	if(org.apache.commons.lang3.StringUtils.isBlank(memberSex)
    			||(!"男".equals(memberSex)&&!"女".equals(memberSex))){
    		System.out.println("性别不通过");
    		return false;
    	}
    	//验证身份证
	    if(org.apache.commons.lang3.StringUtils.isNotBlank(IDCard)&&!ValidatesUtil.isIDCard(IDCard)){//若身份证号不为空，则进行验证
	    	System.out.println("身份证不通过");
	    	return false;
	    }
		return validateFlag;
    }
    
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
//		if(validateRegisterMemberParam()==true){
//			System.out.println("验证通过");
//		}else{
//			System.out.println("验证不通过");
//		}
    	
	}

}
