package rpc.tcp;

public class SayHelloServiceImp implements SayHelloService{

	public String sayHello(String helloArg) {
		// TODO Auto-generated method stub
		if("Hello".equals(helloArg))
			return "Hello";
		else	
		    return "Bye Bye";
	}

}
