package com.sleeptask;
import android.widget.Toast;

public class ToastPrompt{
    
    public static void toast(String prompt){
		
		Toast.makeText(new MainActivity().context(),prompt,Toast.LENGTH_SHORT).show();
		
	}
    
}
