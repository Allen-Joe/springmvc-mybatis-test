package concurrency.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MainThread {

	public static void main(String[] args) {
//		for (int i = 0; i < 2; i++) {
//			LiftOff liftOffTask=new LiftOff();
//			liftOffTask.run();
//		}
		//new Thread(new LiftOff()).start();
		
		//获取java线程管理MXBean
		ThreadMXBean threadMXBean=ManagementFactory.getThreadMXBean();		
		//仅获取线程和线程堆栈信息
		ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false, false);
		//遍历线程信息，打印线程id和线程名称
		for (ThreadInfo threadInfo : threadInfos) { 
			System.out.println("["+threadInfo.getThreadId()+"] "+threadInfo.getThreadName());
		}
	}
}
