package proxy.normal;
/**
 * GamePlayerNormal的代理类
 * @author user
 *
 */
public class GamePlayerProxyNormal implements IGamePlayerNormal{
	
	private GamePlayerNormal gamePlayerNormal=null;
	
	public GamePlayerProxyNormal(String name){
		gamePlayerNormal=new GamePlayerNormal(name);
	}

	public void login(String username, String passWord) {
		// TODO Auto-generated method stub
		this.gamePlayerNormal.login(username, passWord);
	}

	public void killBoss() {
		// TODO Auto-generated method stub
		this.gamePlayerNormal.killBoss();
	}

	public void upGrade() {
		// TODO Auto-generated method stub
		this.gamePlayerNormal.upGrade();
	}

}
