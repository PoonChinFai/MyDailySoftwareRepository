package com.tw;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;

interface ButtonActor 
{
	Texture []texture=new Texture[2];
	texture[0]=new Texture();
 	AssetManager assetManager=new AssetManager();

	void ButtonActor();
}
