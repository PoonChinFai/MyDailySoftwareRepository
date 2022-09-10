package com.tw;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame  implements ApplicationListener
{

	SpriteBatch batch;
	BitmapFont font;
	static AssetManager resource_module;
	static MyGdxGame game;
	Stage stage;

	MainStage mainstage;
	Picture_resources.Role picture_resourceRole;
	Picture_resources picture_resource;
	

	public MyGdxGame()
	{
		new Role();
	}

	@Override
	public void create()
	{
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

	}

	@Override
	public void render()
	{        
		System.out.println("帧数函数");
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(Picture_resources.background_resources[0], 0, 0, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());

		

		batch.end();
		mainstage.act();
		mainstage.draw();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}




}
