package com.mobilebytes.wind;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class Game extends BaseGameActivity{
	
	public static final int CAMERA_WIDTH = 0;
	public static final int CAMERA_HEIGHT = 0;
	public static Game Instance;
	public GameScene mPlayScene;
	public LoadingScene mLoadingScene;

	@Override
	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoadResources() {
		Game.Instance = this;
		
	}

	@Override
	public Scene onLoadScene() {
		mPlayScene = new PlayScene(1, mEngine, this);
        mPlayScene.LoadResources(false);
 
        // create a simple loading scene
        mLoadingScene = (LoadingScene) new Scene(1);
        mLoadingScene.setBackgroundEnabled(true);
        mLoadingScene.setBackground(new ColorBackground(0.f, 0.f, 0.f));
        //okay not null need to load from assets/gfx
        TextureRegion mLoadingBackgroundTextureRegion = null;
		final Sprite loadingSprite = new Sprite(0, 0, mLoadingBackgroundTextureRegion);
        mLoadingScene.getLastChild().attachChild(loadingSprite);
        return mLoadingScene;
	}

	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

}
