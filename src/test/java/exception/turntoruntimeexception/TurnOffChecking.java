package exception.turntoruntimeexception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TurnOffChecking {
	
	public static void main(String[] args) {
		
		WrapCheckedException wce=new WrapCheckedException();
		
		//此处调用throwRuntimeException方法不用抛出异常或者用try块处理
		//因为此方法抛出异常为RunTimeException（不受检查异常）
		wce.throwRuntimeException(3);
		
		for (int i = 0; i < 4; i++) {
			try {
				if(i<3){
					wce.throwRuntimeException(i);
				}else{
				   throw new SomeOtherException();
				}
			} catch (SomeOtherException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (RuntimeException re) {
				// TODO: handle exception
				try {
					throw re.getCause();
				} catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

}
