import org.apache.commons.lang3.StringUtils;


public class JavaIntegerCache {

	public String getExtendParamValue(String extendvalue,String targetParam){
		String targetParamVulue=null;
		if(StringUtils.isNotBlank(extendvalue)){
			String[] params=extendvalue.split(";");
			for (String param : params) {
				if(param.indexOf(targetParam)!=-1){
					String[] subParams=param.split("=");
					if(subParams!=null&&subParams.length>1){
						targetParamVulue=subParams[1];
						break;
					}
				}
			}
		}
		return targetParamVulue;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Integer i1=3;
//		Integer i2=3;
//		Integer i1=new Integer(3);
//		Integer i2=new Integer(3);
//		
//		if(i1==i2)
//			System.out.println("i1等于i2");
//		else
//			System.out.println("i1不等于i2");
//		
//		Integer i3=128;
//		Integer i4=128;
//		
//		if(i3==i4)
//			System.out.println("i3等于i4");
//		else
//			System.out.println("i3不等于i4");
//		
//		
//		String str="ABCDEFG";
//		StringBuffer strbuffer=new StringBuffer();
//		char[] arr=str.toCharArray();
//		int len=arr.length;
//		for (int i=len-1;i>=0;i--) {
//			strbuffer.append(arr[i]);
//		}
//		System.out.println(strbuffer.toString());
		JavaIntegerCache test=new JavaIntegerCache();
		String extend="sugCheckOut=12点00分;sugCheckIn=14点00分;allowMinors=0;isWithPets=0;timeZone=GMT+8;policy=分店无免费停车场，如需停车，可将车辆停至周边停车场，谢谢！;havebreakfast=1";
		String val=test.getExtendParamValue(extend,"sugCheckOut");
		System.out.println(val);
		
	}

}
