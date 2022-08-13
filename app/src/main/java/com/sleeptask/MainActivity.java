package com.sleeptask;

import android.app.Activity;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;

import java.io.*;
import java.util.Date;

public class MainActivity extends Activity {

	String file_name = "/storage/emulated/0/SleepTask/SleepTask.txt";
	String directory_name = "/storage/emulated/0/SleepTask";
	File directory;//文件夹引用
	File file;//文件引用
	EditText time_request;//编辑框
	FileInputStream file_input;
	FileOutputStream file_output;
	BufferedReader read_data;
	BufferedWriter write_data;

	TextView dataDisplay;
	String datalist;
	String exist_data;
	WindowManage winmanage;
	TextView task_prompt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		time_request = findViewById(R.id.time_request);
		dataDisplay = findViewById(R.id.dataDisplay);
		databaseInit();
		winmanage = new WindowManage();
		winmanage.WindowManage(this);
		task_prompt = new TextView(this);
		task_prompt.setTextColor(Color.BLACK);
		task_prompt.setText("该睡觉了");
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			timeManager();
			toast("正在运行");
		} else {
			toast("你的安卓系统过低，无法使用此功能" + "需要API:" + Build.VERSION.SDK_INT);
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


			FileInputStream selectdata = new FileInputStream(file_name);
			read_data = new BufferedReader(new InputStreamReader(selectdata));


			while (true) {
				if ((exist_data = read_data.readLine()) != null) {
					break;
				}


				for (int i = 0; i <= 9; i++) if (i > 9) break;
			}
		} catch (IOException e) {
		}


		return exist_data;

	}

	public void display(View v) {

		datalist = fileManager();
		toast("666");
		dataDisplay.setText(datalist);


	}

	public void dataDisplay() {
		new Thread(new Runnable() {//五秒自动刷新数据
			@Override
			public void run() {

				while (true) {

					datalist = fileManager();

					runOnUiThread(new Runnable() {
						@Override
						public void run() {

							dataDisplay.setText(datalist);
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

	public void add_date(View v) {

		String time_data = time_request.getText().toString();

		write_data = new BufferedWriter(new OutputStreamWriter(file_output));
		if (time_data.equals("")) {
			toast("时间为空");
		} else if (!time_data.equals("")) {

			toast("加入成功,时间为" + time_data);
			try {
				write_data.write(time_data);
				write_data.newLine();
				write_data.flush();
			} catch (IOException e) {
			}


		}

	}

	public void delete_data(View v) {

		if (getFile().exists()) {
			getFile().delete();
			toast("删除成功");
		} else {
			toast("文件夹为空");
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
			file_output = new FileOutputStream(file_name);

			read_data = new BufferedReader(new InputStreamReader(file_input));
			String exist_data = null;
			exist_data = read_data.readLine();
			if (exist_data == null) toast("未配置时间");

		} catch (FileNotFoundException e) {
			System.out.println("171");
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

	@RequiresApi(api = Build.VERSION_CODES.N)
	public void timeManager() {


		SimpleDateFormat dateformat = new SimpleDateFormat("HHmmss");
		int timeformat = Integer.parseInt(dateformat.format(new Date()));

		new Thread(new Runnable() {
			@Override
			public void run() {


				while (true) {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {

							if (timeformat == 213000) {
								openSuspension();
							}
							if (timeformat == 073000) {
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


	public void toast(final String prompt) {
		new Thread(new Runnable() {

			@Override
			public void run() {


				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(MainActivity.this, prompt, Toast.LENGTH_SHORT).show();

					}
				});
			}
		}).start();

	}

} 
