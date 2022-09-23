package com.sleeptask;
import java.util.concurrent.*;
import java.util.*;

public class ThreadPool  implements Runnable
{

	@Override
	public void run()
	{
		// TODO: Implement this method
	}
	

	

	
	ExecutorService executorService=Executors.newCachedThreadPool();
	Thread thread;
 	public ThreadPool(){
	
		
		thread=new Thread(this);
		executorService.execute(thread);
		
	}
	
	/*public void ThreadPool(){
		new TimerOperator();
	}
	*/

}
