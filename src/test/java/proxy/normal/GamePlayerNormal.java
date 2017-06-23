package proxy.normal;

public class GamePlayerNormal implements IGamePlayerNormal{
	private String name="";

	public GamePlayerNormal(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}

	public void login(String username, String passWord) {
		// TODO Auto-generated method stub
		System.out.println("账号为"+username+"的用户"+this.name+"成功登录了游戏");
	}

	public void killBoss() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"在刷怪");
	}

	public void upGrade() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"又升了一级");
	}


}
