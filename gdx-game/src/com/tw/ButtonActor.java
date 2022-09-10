package com.tw;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.g2d.*;


	public  class ButtonActor {
		ImageButton imageButton,imageButton2;
		public void buttonActor(){
			Texture []texture=new Texture[2];
			texture[0]=new Texture(Gdx.files.internal("Left.png"));
			texture[1]=new Texture(Gdx.files.internal("Right.png"));
			texture[2]=new Texture(Gdx.files.internal("Checkout.png"));
			AssetManager assetManager=new AssetManager();
			
			
			TextureRegionDrawable button_basicLeft=new TextureRegionDrawable(new TextureRegion(texture[0]));
			TextureRegionDrawable button_basicRight=new TextureRegionDrawable(new TextureRegion(texture[1]));
			TextureRegionDrawable button_basicCheckout=new TextureRegionDrawable(new TextureRegion(texture[2]));
			imageButton=new ImageButton(button_basicLeft);
			imageButton2=new ImageButton(button_basicRight);
			imageButton.setPosition(50,100);
			imageButton2.setPosition(Gdx.graphics.getWidth()-50,100);
			
			
		}
	}


