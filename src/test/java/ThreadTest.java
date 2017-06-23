import java.util.ArrayList;
import java.util.List;


public class ThreadTest {
	 static int i=0;
	 static String isSuccess="0";
     public static void main(String[] args) {
    	 for (;i < 5; i++) {
    		new Thread("线程"+i+""){
    			public void run() { 
    				if("1".equals(isSuccess)){
    					return;
    				}
	 			    int[] intArray=new int[10];
					synchronized (isSuccess) {
	    				for (int j = 0; j < 10; j++) {  							
	    					if(j==8){
	        					intArray[j]=j;
	        					isSuccess="1";
	        					System.out.println(Thread.currentThread().getName()+"先达到条件啦。。。");
	        					break;
	    					}
						}
	    				return;
					}
    			};	
    		}.start();
		 }    
	}

}
