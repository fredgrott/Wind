package com.mobilebytes.wind;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSCounter;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.HorizontalAlign;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;

import android.graphics.Color;
import android.graphics.Typeface;


public class MainActivity extends BaseGameActivity {
	private static final int CAMERA_WIDTH = 720;
    private static final int CAMERA_HEIGHT = 480;

    private Camera mCamera;
    protected Texture mFontTexture;
    protected Font mFont;
    
    private SceneManager sm;
    
    @Override
    public Engine onLoadEngine() {
            this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
            return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));
    }

    @Override
    public void onLoadResources() {
            this.mFontTexture = new Texture(256, 256, TextureOptions.BILINEAR);

            this.mFont = new Font(this.mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.BLACK);

            this.getEngine().getTextureManager().loadTexture(this.mFontTexture);
            this.getEngine().getFontManager().loadFont(this.mFont);
            
            this.sm = new SceneManager(this);
    }

    @Override
    public Scene onLoadScene() {
            this.getEngine().registerUpdateHandler(new FPSCounter());
            
            final Scene scene = new Scene(1);
            scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));

            final Text textCenter = new Text(100, 60, this.mFont, "this is a loading page :)", HorizontalAlign.CENTER);
            scene.getLastChild().attachChild(textCenter);
            
            scene.registerUpdateHandler(new TimerHandler(1.0f, true, new ITimerCallback() {
                @Override
                public void onTimePassed(final TimerHandler pTimerHandler) {
                	scene.unregisterUpdateHandler(pTimerHandler);
                	
                    Texture mTexture = new Texture(32, 32, TextureOptions.BILINEAR);
                    TextureRegion mTextureRegion = TextureRegionFactory.createFromAsset(mTexture, MainActivity.this, "gfx/gfx.png", 0, 0);
                    mEngine.getTextureManager().loadTexture(mTexture);
                    
                    Texture mTexture2 = new Texture(32, 32, TextureOptions.BILINEAR);
                    TextureRegion mTextureRegion2 = TextureRegionFactory.createFromAsset(mTexture2, MainActivity.this, "gfx/gfx2.png", 0, 0);
                    mEngine.getTextureManager().loadTexture(mTexture2);
                    
                    Texture mTexture3 = new Texture(32, 32, TextureOptions.BILINEAR);
                    TextureRegion mTextureRegion3 = TextureRegionFactory.createFromAsset(mTexture3, MainActivity.this, "gfx/gfx3.png", 0, 0);
                    mEngine.getTextureManager().loadTexture(mTexture3);
                	
                    MainActivity.this.sm.loadMain();
                }
        	}));
            
            return scene;
    }

    @Override
    public void onLoadComplete() {
    	
    }
}