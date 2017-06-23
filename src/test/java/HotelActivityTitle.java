

public class HotelActivityTitle {

	private String actCode;  //活动编码
	private String actName;  //活动名称
	
	public HotelActivityTitle(String actCode,String actName){
		this.actCode=actCode;
		this.actName=actName;
	}
	
	public String getActCode() {
		return actCode;
	}
	public void setActCode(String actCode) {
		this.actCode = actCode;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		HotelActivityTitle hotelActivityTitle=(HotelActivityTitle) obj;
		return actCode.equals(hotelActivityTitle.actCode);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		String in=actCode;
		return in.hashCode();
	}
	

}
