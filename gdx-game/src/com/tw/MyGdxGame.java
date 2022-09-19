package com.tw;


import android.content.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;

public class MyGdxGame implements ApplicationListener
{

	float x;
	 
	SpriteBatch batch;
	BitmapFont font;
	static AssetManager resource_module;
	static MyGdxGame game;
	Stage stage;

	MainStage mainstage;
	Picture_resources.Role picture_resourceRole;
	Picture_resources picture_resource;

	
	boolean i=true;

	Context context;
	public MyGdxGame()
	{
		new Role();

		 }

	
	public void create()
	{
		
		//new ToastPrompt.toastPrompt(context.getApplicationContext());
		System.out.println("初始化函数");
		
		//资源管理器
		resource_module = new AssetManager();
		//笔
		batch = new SpriteBatch();
		//写字的手
		font = new BitmapFont();

		//初始化背景资源
		picture_resource.background();
		//初始化人物资源
		picture_resourceRole.ikun();
		//实例化对象
		mainstage = new MainStage();

		//stageOperator();



		//设置文字颜色
		font.setColor(Color.RED);
		//设置文字大小倍数
		font.setScale(5);


		//初始化人物动画
		Role.role();
		//初始化演员

		//监听舞台

		
		Gdx.input.setInputProcessor(mainstage);

		//new MainStage().checkout();
	}

	
	public void render()
	{        
	
		
		
		System.out.println("帧数函数");
	   
		Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		
		batch.draw(Picture_resources.background_resources[0], 0, 0, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());

		

		if(Gdx.input.isTouched()){font.draw(batch,"sss",500,100);}
		batch.end();
		
		mainstage.act();
		mainstage.draw();
	}
	
	public void dispose()
	{
	}

	
	public void resize(int width, int height)
	{
	}

	
	public void pause()
	{
	}

	
	public void resume()
	{
	}




}
