package proxy.normal;
/**
 * 代理中的"普通代理模式"（场景类只能通过代理类进行访问，不能创建真实角色类，不能通过真实角色类访问）
 * @author user
 *
 */
public interface IGamePlayerNormal {

	//登录
	public void login(String username,String passWord);
	
	//杀怪
	public void killBoss();
	
	//升级
	public void upGrade();

}
