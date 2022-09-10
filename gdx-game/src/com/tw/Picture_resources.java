package com.tw;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.assets.*;
import android.telephony.*;
import com.badlogic.gdx.*;

public class Picture_resources
{

	static Texture [] background_resources;
	static AssetManager resourceManager=new AssetManager();
	static Picture_resources.Role role=new Picture_resources.Role();
	public  Picture_resources()
	{

	}
	public static class Role
	{

		static Texture []role_resources = new Texture[1024]; ;



		public static void ikun()
		{
			role.resourcesOperator("youbeautiful.png");
			resourceManager.update();
		}
		public void resourcesOperator(String resource)
		{
			int index=0;
			role_resources[index++] = new Texture(Gdx.files.internal(resource));
			resourceManager.load(resource, Texture.class);

		}

	}


	
	public static void background()
	{
		background_resources = new Texture[1024];
		background_resources[0] = new Texture(Gdx.files.internal("android.jpg"));
		background_resources[1] = new Texture(Gdx.files.internal("IMG.jpg"));
		//while(true){if(resourceManager.update())
		resourceManager.load("IMG.jpg", Texture.class);
		//break;}
		resourceManager.load("android.jpg", Texture.class);
		resourceManager.update();
	}
}
