package proxy.dynamic;

public interface IGamePlayer {

	//登录
	public void login(String username,String passWord);
	
	//杀怪
	public void killBoss();
	
	//升级
	public void upGrade();

}
