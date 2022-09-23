package com.sleeptask;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.icu.text.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.sleeptask.*;
import java.io.*;
import java.util.*;
//import android.R;

public class MainActivity extends Activity implements Runnable
{


	public static MainActivity context;

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
	//static ToastPrompt ToastPrompt;
	//TimeManager timemanager;

	Intent intent;


	IntentFilter filter = new IntentFilter();//动态注册屏幕广播




	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//--------------///
		setContentView(R.layout.activity_main);
		time_request = findViewById(R.id.time_request);
		dateDisplay = findViewById(R.id.dateDisplay);
		//--------------




		winmanage = new WindowManage();//悬浮窗实例化对象
		winmanage.WindowManage(this);//调用方法创建悬浮窗,传入上下文对象
		//timemanager=new TimeManager(this);
		context = this;//声明，一个全局上下文变量
		//new ThreadPool();
		//-----------------

		//--------------------
		intent = new Intent(this, Notification.class);//实例化意图对象,传入上下文对象,服务
		task_prompt = new TextView(this);//实例化控件对象，传入上下文对象
		task_prompt.setTextColor(Color.BLACK);
		task_prompt.setText("该睡觉了");
		filter.addAction(Intent.ACTION_SCREEN_ON);

		//---------------

		databaseInit();
		registerReceiver(new Broadcaster(), filter);//注册广播接收对象,传入注册者

		//new ThreadPool();

		new TimerOperator();
		//startForegroundService();
		startService(intent);
		//dataDisplay();
		//	new publicEvent(this).	publicEvent("frereopwir");
		//-----------------
		if (!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N))
		{


			//System.out.println("ok    "+ToastPromp);
			ToastPrompt.	toast("你的安卓系统过低，无法使用此功能" + "需要API:" + Build.VERSION.SDK_INT);
		}


	}




	public File getDirectory()
	{//获取文件夹
		directory = new File(directory_name);
		return directory;//返回文件夹引用
	}

	public File getFile()
	{//获取文件

		file = new File(file_name);
		return file;//返回文件引用
	}

	public String fileManager()
	{


		try
		{


			read_data = new BufferedReader(new InputStreamReader(file_input));



			if ((exist_data = read_data.readLine()) != null)
			{
				ToastPrompt.toast("Data is  already loaded ");
				System.out.println("true");
			}
			else
			{

				System.out.println(exist_data);
				System.out.println("false");
				//read_data.close();
			}
		}
		catch (IOException e)
		{
		}


		return exist_data;

	}

	public void display(View v)
	{

		datalist = fileManager();

		ToastPrompt.toast("已存入数据:" + datalist);
		dateDisplay.setText(datalist);


	}
	/*
	 public void dataDisplay()
	 {

	 final Thread i=new Thread(new Runnable() {//五秒自动刷新数据
	 @Override
	 public void run()
	 {

	 while (true)
	 {



	 runOnUiThread(new Runnable() {
	 @Override
	 public void run()
	 {

	 datalist = fileManager();
	 System.out.println("  ok       "+datalist);
	 dateDisplay.setText(datalist);
	 }
	 });
	 try
	 {
	 Thread.sleep(5 * 1000);
	 }
	 catch (InterruptedException e)
	 {
	 throw new RuntimeException(e);
	 }

	 }

	 }
	 });

	 i.start();
	 new Thread(new Runnable(){

	 @Override
	 public void run()
	 {
	 while(true){
	 System.out.println("    stop");
	 if(datalist==null){i.stop();break;}
	 // TODO: Implement this method
	 }
	 }


	 }	).start();

	 }

	 */
	public void openService(View v)
	{
		/*String id="666";
		 String name="name";
		 NotificationChannel channel=new NotificationChannel(id,name,NotificationManager.IMPORTANCE_LOW);

		 intent=new Intent(this,Notification.class);
		 PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

		 NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);//获取通知栏管理对象
		 Notification.Builder builder=new Notification.Builder(this);//获取通知栏builder对象

		 manager.createNotificationChannel(channel);


		 //builder.setSmallIcon(R.id.delete);
		 builder.setTicker("uploadservice");
		 builder.setContentText("请保持程序在后台运行");
		 builder.setWhen(System.currentTimeMillis());
		 builder.setContentIntent(pendingIntent);

		 Notification notification=builder.getNotification();
		 manager.notify(0,notification);
		 // startForeground(1,notification);
		 ToastPrompt.toast("启动服务成功");
		 */
	}
	public void closeService(View v)
	{

		stopService(intent);
	}

	public void add_date(View v)
	{
		//System.out.println("ok        "+ToastPrompt);
		if (!getFile().exists())databaseInit();
		String time_data = time_request.getText().toString();

		write_data = new BufferedWriter(new OutputStreamWriter(file_output));
		if (time_data.equals(""))
		{
			ToastPrompt.toast("时间为空");
			//System.out.println("ok    "+ToastPrompt);
		}
		else if (!time_data.equals(""))
		{


			try
			{
				write_data.write(time_data);
				write_data.newLine();
				write_data.flush();
			}
			catch (IOException e)
			{
			}

			ToastPrompt. toast("加入成功,时间为" + time_data);
			//System.out.println("ok    "+ToastPrompt);

		}


	}

	public void delete_data(View v)
	{

		if (getFile().exists())
		{
			getFile().delete();
			ToastPrompt.	toast("删除成功");
		}
		else
		{
			ToastPrompt.	toast("文件夹为空");
		}
	}

	public void databaseInit()
	{//数据库初始化

		try
		{


			if (!(getDirectory().exists()))
			{
				getDirectory().mkdir();
				if (!(getFile().exists()))
				{

					getFile().createNewFile();

				}

			}
			else if (getDirectory().exists())
			{
				if (!getFile().exists())
				{

					getFile().createNewFile();

				}

			}

			file_input = new FileInputStream(file_name);

			file_output = new FileOutputStream(file_name, true);


			read_data = new BufferedReader(new InputStreamReader(file_input));
			String exist_data = null;

			exist_data = read_data.readLine();


			if (exist_data == null) ToastPrompt.toast("未配置时间");

		}
		catch (FileNotFoundException e)
		{

		}
		catch (IOException e)
		{
		}
	}


	public void getDate()
	{

	}

	public void openSuspension()
	{//打开悬浮窗
		winmanage.window.addView(task_prompt, winmanage.windowlayout);
	}

	public void closeSuspension()
	{//关闭悬浮窗
		winmanage.window.removeView(task_prompt);
	}


	@Override
	protected void onDestroy()
	{
		startService(intent);
		super.onDestroy();

	}

	@Override
	public void run()
	{

		final SimpleDateFormat dateformat = new SimpleDateFormat("HHmmss");
		int timeformat = Integer.parseInt(dateformat.format(new Date()));
		if (timeformat == 154700)
		{
			openSuspension();
		}
		if (timeformat == 155000)
		{
			closeSuspension();
		}

		// TODO: Implement this method
	}












} 
