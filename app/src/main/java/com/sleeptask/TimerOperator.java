package com.sleeptask;
import java.security.*;

public class TimerOperator extends ThreadPool 
{


	public TimerOperator(){
		ToastPrompt.toast("定时器已启动");
	}
		public void run(){
		while (true)
		{
			//run(dateformat);
			MainActivity.context.runOnUiThread(MainActivity.context);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
		
}
	
	
	
}
