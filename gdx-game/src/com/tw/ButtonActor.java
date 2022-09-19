package com.tw;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.actions.*;



public  interface ButtonActor 
{
	
	
	Image imagebutton_Left;
	Image imagebutton_Right;
	Image imagebutton_Checkout;
	Texture[] texture=new Texture[3];
	AssetManager assetManager=new AssetManager();
	Vector2 moving=new Vector2();
	TextureRegionDrawable button_basicLeft, button_basicRight, button_basicCheckout;
	
	
	
	public void checkout();
	void movment();
	
	float distance=300f;
	

	public class ButtonOperator{
		public void ButtonOperator(){
			texture[0] = new Texture(Gdx.files.internal("Left.png"));
			texture[1] = new Texture(Gdx.files.internal("Right.png"));
			texture[2] = new Texture(Gdx.files.internal("Checkout.png"));
			assetManager.load("Left.png", Texture.class);
			assetManager.load("Right.png", Texture.class);
			assetManager.load("Checkout.png", Texture.class);
			assetManager.update();
			
			button_basicLeft = new TextureRegionDrawable(new TextureRegion(texture[0]));
			button_basicRight = new TextureRegionDrawable(new TextureRegion(texture[1]));
			button_basicCheckout = new TextureRegionDrawable(new TextureRegion(texture[2]));
			
			imagebutton_Left = new Image(button_basicLeft);

			imagebutton_Right = new Image(button_basicRight);
			//imagebutton_Checkout=new ImageButton(button_basicCheckout);
			imagebutton_Left.setPosition(100f, 100f);
			imagebutton_Left.setScale(3);

			imagebutton_Right.setPosition(100f+distance, 100f);
			imagebutton_Right.setScale(3);
			
			
			}
			public void ButtonOperator(String[] picture,float XY,float positionX,float positionY){
				texture[0] = new Texture(Gdx.files.internal(picture[0]));
				texture[1] = new Texture(Gdx.files.internal(picture[1]));
				texture[2] = new Texture(Gdx.files.internal(picture[2]));
				
				assetManager.load(picture[0], Texture.class);
				assetManager.load(picture[1], Texture.class);
				assetManager.load(picture[2], Texture.class);
				assetManager.update();

				button_basicLeft = new TextureRegionDrawable(new TextureRegion(texture[0]));
				button_basicRight = new TextureRegionDrawable(new TextureRegion(texture[1]));
				button_basicCheckout = new TextureRegionDrawable(new TextureRegion(texture[2]));

				imagebutton_Left = new Image(button_basicLeft);

				imagebutton_Right = new Image(button_basicRight);
				//imagebutton_Checkout=new ImageButton(button_basicCheckout);
				imagebutton_Left.setPosition(positionX,positionY);
				imagebutton_Left.setScale(XY);

				imagebutton_Right.setPosition(positionX+distance,positionY);
				imagebutton_Right.setScale(XY);
			}
	}
	public class Listen extends ClickListener
	{
		static float a;
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
		{
			// TODO: Implement this method
			this.moving();
			System.out.println("touchdown"+"   "+x+" "+y);
			return super.touchDown(event, x, y, pointer, button);
		}
		public static void moving(){
			new MyGdxGame().x++;
		}

	}
}

