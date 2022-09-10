package com.tw;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;

public class MainStage extends Stage
{

	 SpriteBatch batch;
	 Picture_resources picture_resource;
	 ImageButton image_button;
	 TextureRegionDrawable down_drawable,up_drawable;
	 float state;

	public  MainStage()
	{


		this.MainStage();
	}
	public void MainStage()
	{
		//picture_resource=new Picture_resources();
		batch = new SpriteBatch();
		down_drawable = new TextureRegionDrawable(new TextureRegion(picture_resource.background_resources[1], 0, 0, 100, 100));

		image_button = new ImageButton(down_drawable, down_drawable);
		image_button.setPosition(50, 100);

		this.addActor(image_button);

	}
	@Override
	public void draw()
	{


		batch.begin();
		//down_drawable.draw(batch,0,0,100,100);
		//	enter.font.draw(batch,"Hello World",Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		state += Gdx.graphics.getDeltaTime();
		batch.draw(Role.movement.getKeyFrame(state, true),100,50 , 500, 500);

		//batch.end();
		batch.end();
		// TODO: Implement this method
		super.draw();
	}


}

