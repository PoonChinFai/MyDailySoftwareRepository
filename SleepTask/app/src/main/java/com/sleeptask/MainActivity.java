package com.sleeptask;

import android.app.Activity;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.io.IOException;
import android.widget.Toast;
import android.widget.EditText;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity { 

	String file_name="/storage/emulated/0/SleepTask/SleepTask.txt";
	String directory_name="/storage/emulated/0/SleepTask";
	File directory;
	File file;
	EditText time_request;
	FileInputStream file_input;
	FileOutputStream file_output;
	BufferedReader read_data;
	BufferedWriter write_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		this.time_request = findViewById(R.id.time_request);
		fileManager();
		databaseInit();
    }
	public File getDirectory() {
		directory = new File(directory_name);
		return directory;
	}
	public File getFile() {

		file = new File(file_name);
		return file;
	}
	public String fileManager() {

		String exist_data=null;
		try {
			file_input = new FileInputStream(file_name);


			file_output = new FileOutputStream(directory_name);

			FileInputStream selectdata=new FileInputStream(file_name);
			BufferedReader read_data=new BufferedReader(new InputStreamReader(selectdata));



			exist_data = read_data.readLine();
		} catch (IOException e) {}


		return exist_data;

	}
	public void add_data(View v) {

		String time_data=time_request.toString();

		write_data=new BufferedWriter(new OutputStreamWriter( file_output));
		if (time_data == null) {toast("时间为空");
		} else {

			try {
				write_data.write(time_data);
			} catch (IOException e) {}



		}

	}
	public void deleteData(View v) {

		if (getFile().exists()) {
			getFile().delete();
			toast("删除成功");
		} else {
			toast("文件夹为空");
		}
	}
	public void databaseInit() {

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

			
			read_data = new BufferedReader(new InputStreamReader(file_input));
			String exist_data=null;

			if ((exist_data = read_data.readLine()) == null)toast("未配置时间");

		} catch (FileNotFoundException e) {} catch (IOException e) {}
	}

	public void timeManager() {


		SimpleDateFormat dateformat=new SimpleDateFormat("HHmm");
		int  timeformat=Integer.parseInt(dateformat.format(new Date()));
		if (timeformat == 0) {

		}
	}
	public void toast(final String prompt) {
		new Thread(new Runnable(){

				@Override
				public void run() {

					runOnUiThread(new Runnable(){

							@Override
							public void run() {
								Toast.makeText(MainActivity.this, prompt, Toast.LENGTH_SHORT).show();

							}
						});
				}
			}).start();

	}

} 
