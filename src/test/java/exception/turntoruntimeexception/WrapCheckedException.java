package exception.turntoruntimeexception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @描述：将“受检查异常”转换为“不受检查异常”
 * @创建人：Chenliqiao
 * @创建时间：2017年3月27日下午2:50:51
 * @version v1.0
 */
public class WrapCheckedException {
	
	void throwRuntimeException(int type){
		try {
			switch (type) {
			case 0: throw new FileNotFoundException();
			case 1: throw new IOException();
			case 2: throw new RuntimeException();
			default:
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			//将受检查异常捕获后转为不受检查异常RuntimeException，然后重新抛出
			throw new RuntimeException(e);
		}
	}

}
