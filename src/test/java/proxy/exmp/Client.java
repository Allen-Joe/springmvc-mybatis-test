package proxy.exmp;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 一般情况的（非代理模式）
		 */
		System.out.println("************非代理模式************");
		GamePlayer gamePlayer=new GamePlayer("张三");
		gamePlayer.login("zhangshan", "123456");
		gamePlayer.killBoss();
		gamePlayer.upGrade();
		
		System.out.println();
		
		/**
		 * 代理模式下的情况
		 */
		System.out.println("************代理模式************");
		GamePlayerProxy proxy=new GamePlayerProxy(gamePlayer);
		proxy.login("zhangshan", "123456");
		proxy.killBoss();
		proxy.upGrade();

	}

}
