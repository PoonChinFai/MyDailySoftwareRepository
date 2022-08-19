package com.sleeptask;
import android.content.Context;
import android.widget.Toast;

public class ToastPrompt{
    
	Context  context;
	public ToastPrompt(Context context){
		this.context=context;
	}
    public  void toast(String prompt){
		
		Toast.makeText(context,prompt,Toast.LENGTH_SHORT).show();
		
	}
    
}
