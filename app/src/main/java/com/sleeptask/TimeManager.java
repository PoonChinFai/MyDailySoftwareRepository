package com.sleeptask;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

public class TimeManager  {

	public BroadcastReceiver broadcast;
	Context context;
	int countdown=0;
	PowerManager screen_control;
	PowerManager.WakeLock screen_lock;
	
	public TimeManager(Context context){
		this.context=context;
		
	
		broadcast = new BroadcastReceiver(){

	
			@Override
			public void onReceive(Context p1, Intent p2) {
				temporary();
			}

		
		};
		screen_control=(PowerManager)context.getSystemService(Context.POWER_SERVICE);
		screen_lock=screen_control.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK,"tag");
		
	}

	public void temporary(){
		new ToastPrompt(context).toast("Broadcast");
	}

	/*
	 BroadcastReceiver mReceiver = new BroadcastReceiver() {
	 @Override
	 public void onReceive(Context context, Intent intent) {
	 if(Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {

	 }
	 }
	 };

	 //动态注册
	 IntentFilter filter = new IntentFilter();
	 filter.addAction(Intent.ACTION_SCREEN_OFF);
	 registerReceiver(mReceiver, filter);

	 //记得在合适的时机比如Activity的onDestroy方法里反注册释放掉资源以免内存泄漏
	 unregisterReceiver(mReceiver);
	*/
	public void screenControl(){
		
	}

   public void timeManager(){
	  new Thread(new Runnable(){

			   @Override
			   public void run() {

				   while(true){
				   try {
				
					   if(countdown>=(1*60))screen_lock.release();
					   countdown++;
					   Thread.sleep(1000);
				   } catch (InterruptedException e) {}
			   }
			   }
		   }).start();
   }
  
	/*
	 PowerManager pm = (PowerManager) MyApplication.mContext.getSystemService(Context.POWER_SERVICE);
	 wakeLock = pm.newWakeLock(, "TAG");
	 wakeLock.acquire();//保持屏幕常亮
	 // wakeLock.acquire(30*1000);//保持屏幕常亮30s

	 new Handler().postDelayed(new Runnable() {
	 @Override
	 public void run() {
	 wakeLock.release();//10s后息屏
	 }
	 },10000);

	 */
    
}
