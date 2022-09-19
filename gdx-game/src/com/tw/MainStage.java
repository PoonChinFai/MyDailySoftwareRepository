package com.tw;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;

public class MainStage extends Stage implements ButtonActor
{
	//float x=new MyGdxGame().x;

	@Override
	public void movment()
	{
		
		// TODO: Implement this method
	}
	
    Texture []texture=new Texture[3];
	AssetManager assetManager=new AssetManager();
	TextureRegionDrawable button_basicLeft, button_basicRight, button_basicCheckout;
	@Override
	public void checkout()
	{

		new ButtonActor.ButtonOperator().ButtonOperator();
		
		this.addActor(ButtonActor. imagebutton_Left);
		this.addActor(ButtonActor. imagebutton_Right);
		ButtonActor.Listen a=new ButtonActor.Listen();
		ButtonActor. imagebutton_Left.addListener(a);
		// TODO: Implement this method
	}


	SpriteBatch batch;
	Picture_resources picture_resource;
	Image imagebutton_Left,imagebutton_Right,imagebutton_Checkout;
	TextureRegionDrawable down_drawable,up_drawable;
	float state;
	//BitmapFont a= new BitmapFont();
	public  MainStage()
	{

		batch = new SpriteBatch();

		this.checkout();
		//new MainStage().checkout();
	}

	@Override
	public void draw()
	{

		//this.checkout();
		super.draw();
		batch.begin();
		//down_drawable.draw(batch,0,0,100,100);
		//	enter.font.draw(batch,"Hello World",Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		state += Gdx.graphics.getDeltaTime();
		batch.draw(Role.movement.getKeyFrame(state, true), new MyGdxGame().x,Role.moving.y, 500, 500);

		//for(int i=0;i<4;i++)Role.moving.x++;
		
		//batch.end();
		batch.end();
		

		// TODO: Implement this method


	}


}

