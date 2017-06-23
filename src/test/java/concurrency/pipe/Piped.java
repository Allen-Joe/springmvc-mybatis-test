package concurrency.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

	static class Print implements Runnable{
		
		private PipedReader in;
		
		public Print(PipedReader in){
			this.in=in;
		}

		public void run() {
			// TODO Auto-generated method stub
			int recieve=0;
			try {
				System.out.println("begin read ..."); 
				while((recieve=in.read())!=-1){
					System.out.print((char)recieve);
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		PipedReader in=new PipedReader();//读出
		PipedWriter out=new PipedWriter();//写入
		
		out.connect(in);
		Thread printThread=new Thread(new Print(in),"PrintThread");
		printThread.start();
		for (char c : "PrintThread".toCharArray()) {
			out.write(c);
		}
//		int recieve=0;
//		try {
//			while((recieve=System.in.read())!=-1){
//	            out.write(recieve);
//			}
//		}finally{
//			out.close();
//		} 
	}
}
