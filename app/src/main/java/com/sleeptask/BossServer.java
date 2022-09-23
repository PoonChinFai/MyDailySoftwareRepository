package com.sleeptask;

import android.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.R;

public class BossServer extends Service 
{

	@Override
	public IBinder onBind(Intent p1) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		ToastPrompt.toast("创建服务成功");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		String id="666";
		String name="name";
		NotificationChannel channel=new NotificationChannel(id,name,NotificationManager.IMPORTANCE_LOW);

		intent=new Intent(this,Notification.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);//获取通知栏管理对象
		Notification.Builder builder=new Notification.Builder(this);//获取通知栏builder对象

		manager.createNotificationChannel(channel);


		builder.setSmallIcon(R.mipmap.sym_def_app_icon);
        builder.setTicker("uploadservice");
        builder.setContentText("请保持程序在后台运行");
        builder.setWhen(System.currentTimeMillis());
		builder.setContentIntent(pendingIntent);

        Notification notification=builder.build();
        startForeground(1,notification);
		ToastPrompt.toast("启动服务成功");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		ToastPrompt.toast("服务已销毁");
		stopForeground(true);
		//unregisterReceiver(this);
		super.onDestroy();
	}

    
    
    
}
