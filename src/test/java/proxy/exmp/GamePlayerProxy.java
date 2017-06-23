package proxy.exmp;
/**
 * GamePlayer的代理类
 * @author user
 *
 */
public class GamePlayerProxy implements IGamePlayer{
	
	private GamePlayer gamePlayer=null;

	public GamePlayerProxy(GamePlayer gamePlayer) {
		// TODO Auto-generated constructor stub
		this.gamePlayer=gamePlayer;
	}

	public void login(String username, String passWord) {
		// TODO Auto-generated method stub
		this.gamePlayer.login(username, passWord);
	}

	public void killBoss() {
		// TODO Auto-generated method stub
		this.gamePlayer.killBoss();
	}

	public void upGrade() {
		// TODO Auto-generated method stub
		this.gamePlayer.upGrade();
	}
	

}
