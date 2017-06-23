package rpc.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Provider {
	
	private static final Map<String,Object> services=new HashMap<String,Object>();//服务列表
	
	static{
		//初始化服务列表
		services.put("SayHelloService", new SayHelloServiceImp());
	}
	
	/**
	 * 
	 * @throws Exception 
	 * @描述:处理客户端请求
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月23日下午4:01:23
	 */
	public void opertatorRequest() throws Exception{
		System.out.println("服务端启动~~~~");
		ServerSocket server = new ServerSocket(8888);
		while(true){
			Socket socket=server.accept();
			
			//读取请求信息
			ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
			String interfaceName=input.readUTF();//接口名称
			String methodName=input.readUTF();//方法名称
			Class<?>[] parameterTypes=(Class<?>[]) input.readObject();//参数类型
			Object[] arguments=(Object[]) input.readObject();//参数对象
			
			//调用服务处理
			Class serviceInterfaceClass=Class.forName(interfaceName);
			Object service=services.get(interfaceName);
			Method method=serviceInterfaceClass.getMethod(methodName, parameterTypes);
			Object response=method.invoke(service, arguments);
            //测试
			Comsumer.rsult.add(response);
			
			//返回response
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(response);
			
			//关闭资源
//			out.close();
//			socket.close();
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		Provider p=new Provider();
		p.opertatorRequest();
	}

}
