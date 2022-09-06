package com.sleeptask;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import android.content.BroadcastReceiver;

public class MainActivity extends Activity  {



	//-----------------------
	String file_name = "/storage/emulated/0/SleepTask/SleepTask.txt";
	String directory_name = "/storage/emulated/0/SleepTask";
	//---------------------
	File directory;//文件夹引用
	File file;//文件引用
	EditText time_request;//编辑框
	FileInputStream file_input;
	FileOutputStream file_output;
	BufferedReader read_data;
	BufferedWriter write_data;

	TextView dateDisplay;
	String datalist;
	String exist_data;
	WindowManage winmanage;
	TextView task_prompt;
	BossServer bossserver;
	ToastPrompt toastPrompt;
	TimeManager timemanager;
	
	Intent intent;
	
	
	IntentFilter filter = new IntentFilter();
	

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		//--------------///
		setContentView(R.layout.activity_main);
		time_request = findViewById(R.id.time_request);
		dateDisplay = findViewById(R.id.dateDisplay);
		//--------------


		
		bossserver = new BossServer(this);
		toastPrompt = new ToastPrompt(this);
		//new TimeManager(this);
		winmanage = new WindowManage();
		winmanage.WindowManage(this);
		timemanager=new TimeManager(this);
		//-----------------

		//--------------------
		intent = new Intent(this, BossServer.class);
		task_prompt = new TextView(this);
		task_prompt.setTextColor(Color.BLACK);
		task_prompt.setText("该睡觉了");
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		
		//---------------

		databaseInit();
		registerReceiver(timemanager.broadcast, filter);
		


		dataDisplay();
		//	new publicEvent(this).	publicEvent("frereopwir");
		//-----------------
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			//timeManager();
			//toastPrompt.toast("正在运行");
		} else {
			toastPrompt.	toast("你的安卓系统过低，无法使用此功能" + "需要API:" + Build.VERSION.SDK_INT);
		}
		//	dataDisplay();
		//fileManager();

	}



	public File getDirectory() {//获取文件夹
		directory = new File(directory_name);
		return directory;//返回文件夹引用
	}

	public File getFile() {//获取文件

		file = new File(file_name);
		return file;//返回文件引用
	}

	public String fileManager() {


		try {



			read_data = new BufferedReader(new InputStreamReader(file_input));



			if ((exist_data = read_data.readLine()) != null) {
				toastPrompt.toast("Data is  already loaded ");
			} else {

				read_data.reset();
			}
			//else if((exist_data=read_data.readLine()).equals(" ")){toastPrompt.toast("nul");}




		} catch (IOException e) {
		}


		return exist_data;

	}

	public void display(View v) {

		datalist = fileManager();

		toastPrompt.	toast("666");
		dateDisplay.setText(datalist);


	}

	public void dataDisplay() {
		new Thread(new Runnable() {//五秒自动刷新数据
				@Override
				public void run() {

					while (true) {



						runOnUiThread(new Runnable() {
								@Override
								public void run() {

									datalist = fileManager();
									dateDisplay.setText(datalist);
								}
							});
						try {
							Thread.sleep(5 * 1000);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}

				}
			}).start();

	}


	public void openService(View v) {
		new Thread(new Runnable(){

				@Override
				public void run() {
					startService(intent);
				}
			});

	}
	public void closeService(View v) {

		stopService(intent);
	}

	public void add_date(View v) {
		if (!getFile().exists())databaseInit();
		String time_data = time_request.getText().toString();

		write_data = new BufferedWriter(new OutputStreamWriter(file_output));
		if (time_data.equals("")) {
			toastPrompt.toast("时间为空");
		} else if (!time_data.equals("")) {


			try {
				write_data.write(time_data);
				write_data.newLine();
				write_data.flush();
			} catch (IOException e) {
			}

			toastPrompt. toast("加入成功,时间为" + time_data);

		}


	}

	public void delete_data(View v) {

		if (getFile().exists()) {
			getFile().delete();
			toastPrompt.	toast("删除成功");
		} else {
			toastPrompt.	toast("文件夹为空");
		}
	}

	public void databaseInit() {//数据库初始化

		try {


			if (getDirectory().exists() == false) {
				getDirectory().mkdir();
				if (getFile().exists() == false) {

					getFile().createNewFile();

				}

			} else if (getDirectory().exists()) {
				if (!getFile().exists()) {

					getFile().createNewFile();

				}

			}
			
			file_input = new FileInputStream(file_name);

			file_output = new FileOutputStream(file_name, true);


			read_data = new BufferedReader(new InputStreamReader(file_input));
			String exist_data = null;

			exist_data = read_data.readLine();


			if (exist_data == null);// toastPrompt.toast("未配置时间");

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}
	}


	public void getDate() {

	}

	public void openSuspension() {//打开悬浮窗
		winmanage.window.addView(task_prompt, winmanage.windowlayout);
	}

	public void closeSuspension() {//关闭悬浮窗
		winmanage.window.removeView(task_prompt);
	}


	public void timeManager() {


		final SimpleDateFormat dateformat = new SimpleDateFormat("HHmmss");


		new Thread(new Runnable() {
				@Override
				public void run() {


					while (true) {
						runOnUiThread(new Runnable() {
								@Override
								public void run() {
									final	int timeformat = Integer.parseInt(dateformat.format(new Date()));
									if (timeformat == 105200) {
										openSuspension();
									}
									if (timeformat == 105500) {
										closeSuspension();
									}

								}
							});
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}


				}
			}).start();
	}

	@Override
	protected void onDestroy() {
		startService(intent);
		super.onDestroy();

	}







} 
