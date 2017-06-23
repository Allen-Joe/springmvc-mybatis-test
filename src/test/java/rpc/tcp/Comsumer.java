package rpc.tcp;

import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Comsumer {
	public static List<Object> rsult=new ArrayList<Object>();
	
	/**
	 * 
	 * @描述:发送信息
	 * @throws Exception
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月23日下午3:56:56
	 */
	public void SendRequest() throws Exception{
		System.out.println("客户端启动~~~");
		Socket socket=new Socket("10.100.31.57", 8888);
		
		//接口名称
		String interfaceName=SayHelloService.class.getName();
		
		//需要远程执行的方法
		Method method=SayHelloService.class.getMethod("sayHello",java.lang.String.class);
		
		//需要传递到远程的参数
		Object[] arguments={"hello"};
		
		
		//将方法名称和参数传递到远程
		ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
		out.writeUTF(interfaceName);//接口名称
		out.writeUTF(method.getName());//方法名称
		out.writeObject(method.getParameterTypes());
		out.writeObject(arguments); 
		
		System.out.println(rsult.size());
		
//		ObjectInputStream is=new ObjectInputStream(socket.getInputStream());
//		Object result=is.readObject();
		
		//关闭资源
		out.close();
		//is.close();
		socket.close();
	}
	
	/**
	 * 
	 * @描述:获取远程返回结果
	 * @return
	 * @throws Exception
	 * @返回类型 Object
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月23日下午3:57:23
	 */
//	public Object getResponse() throws Exception{
//		ObjectInputStream is=new ObjectInputStream(socket.getInputStream());
//		Object result=is.readObject();
//		
//		//关闭资源
//		is.close();
//		socket.close();
//		return result;
//	}
	
	public static void main(String[] args) throws Exception {
		Comsumer c=new Comsumer();
		c.SendRequest();
	}
}
