package com.tw;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;
import android.media.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public  class Role implements ButtonActor
{
	

	static Texture texture;

	static TextureRegion animation_picture[][],conversion[];
	static Animation movement;
	static MyGdxGame public_resource;
	static Picture_resources.Role picture_resource;

	ImageButton imageButton,imageButton2;

	@Override
	public void ButtonActor()
	{
		TextureRegionDrawable button_basic=new TextureRegionDrawable(new TextureRegion());
		TextureRegionDrawable button_basicRight=new TextureRegionDrawable(new TextureRegion());
		imageButton=new ImageButton(button_basic);
		imageButton2=new ImageButton(button_basicRight);
		imageButton.setPosition(50,100);
		imageButton2.setPosition(Gdx.graphics.getWidth()-50,100);
		
		// TODO: Implement this method
		
	}
	
	
	
	public Role()
	{
		//new Texture(Gdx.files.external("/storage/emulated/0/DCIM/Camera/IMG_20220801_121659.jpg"));

		//role();
	}
	public   static final void role()
	{
		int frame_rows=11,frame_cols=18;


		Texture role_texture=picture_resource.role_resources[0];
	 	int role_width=role_texture.getWidth() / frame_cols,role_height=role_texture.getHeight() / frame_rows;
		animation_picture = TextureRegion.split(role_texture, role_width, role_height);
		conversion = new TextureRegion[frame_rows * frame_cols];

		int index=0;


		for (int i=0;i < frame_rows;i++)
		{
			for (int j=0;j < frame_cols;j++)
			{
				conversion[index++] = animation_picture[i][j];
			}
		}
		movement = new Animation(0.05f, conversion);
		movement.setPlayMode(Animation.PlayMode.LOOP);
		final float 速度=1;




	}

	public static  class Name_007 extends Role
	{

		public  static void name_007()
		{


		}
	}
	public static class Ikun extends Role{
	//	int skill;
		int speed=5;
		String[] saying={"你干嘛～～～","厉不厉害你坤哥"};
		public void bollKill(){
			
		}
	}

}
