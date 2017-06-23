package proxy.normal;

public class ClientNormal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 代理模式中的普通代理模式：要求客户端只能访问代理类，不能直接访问真实角色类
		 * 如下：只需传入真实角色的姓名就能通过代理类进行访问
		 */		
		GamePlayerProxyNormal proxy=new GamePlayerProxyNormal("张三");
		proxy.login("zhangshan", "123456");
		proxy.killBoss();
		proxy.upGrade();
	}

}
