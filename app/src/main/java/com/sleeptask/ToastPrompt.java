package com.sleeptask;
import android.content.Context;
import android.widget.Toast;

public class ToastPrompt{
    

	
	public ToastPrompt(){
		
	}
    public  void toast(String prompt,int i){
		
		Toast.makeText(MainActivity.context,prompt,Toast.LENGTH_SHORT).show();
		
	}
	public static void  toast(String prompt){
	
	
		new ToastPrompt().toast(prompt,0);
	}
	
    
}
