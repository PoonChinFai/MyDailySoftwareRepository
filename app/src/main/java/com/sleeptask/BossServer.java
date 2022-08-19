package com.sleeptask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class BossServer extends Service {

	Context context ;
	public BossServer(Context context){
		this.context=context;
	}
	@Override
	public IBinder onBind(Intent p1) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		new ToastPrompt(context).toast("创建服务成功");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new ToastPrompt(context).toast("启动服务成功");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		new ToastPrompt(context).toast("服务已销毁");
		super.onDestroy();
	}

    
    
    
}
