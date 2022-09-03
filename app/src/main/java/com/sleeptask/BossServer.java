package com.sleeptask;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class BossServer extends Service {

	Context context ;
	ToastPrompt toastPrompt;
	public BossServer(Context context){
		this.context=context;
		
		toastPrompt=new ToastPrompt(context);
	}
	@Override
	public IBinder onBind(Intent p1) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		toastPrompt.toast("创建服务成功");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Notification.Builder builder=new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.sym_def_app_icon);
        builder.setTicker("uploadservice");
        builder.setContentText("请保持程序在后台运行");
        builder.setWhen(System.currentTimeMillis());
        intent=new Intent(context,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification=builder.build();
        startForeground(1,notification);
		toastPrompt.toast("启动服务成功");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		toastPrompt.toast("服务已销毁");
		stopForeground(true);
		super.onDestroy();
	}

    
    
    
}
