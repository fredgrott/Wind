package com.mobilebytes.wind;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;

import android.graphics.Color;

public class PlayScene extends GameScene {

	public PlayScene(int pLayerCount, Engine baseEngine, Game game) {
		super(pLayerCount, baseEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onLoadResources() {
        IAsyncCallback callback = new IAsyncCallback() {

            @Override
            public void workToDo() {
                TextureRegionFactory.setAssetBasePath("gfx/game/");
                FontFactory.setAssetBasePath("font/");
                
                /**
                 * example to see what needs to happen/to load
                 * 
                 * PlayScene.this._backgroundTexture = new Texture(512, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._backgroundTextureRegion = TextureRegionFactory.createFromAsset(PlayScene.this._backgroundTexture, Game.Instance, "background0.png", 0, 0);
                PlayScene.this._backgroundTextureRegion2 = TextureRegionFactory.createFromAsset(PlayScene.this._backgroundTexture, Game.Instance, "background0.png", 0, 0);
                PlayScene.this._backgroundTextureRegion2.setFlippedVertical(true);

                PlayScene.this._faceTexture = new Texture(32,32,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._faceTextureRegion = TextureRegionFactory.createTiledFromAsset(PlayScene.this._faceTexture,Game.Instance,"face_box.png", 0,0,1,1);

                PlayScene.this._iffishTexture = new Texture(512,512,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._iffishTextureTile = TextureRegionFactory.createTiledFromAsset(PlayScene.this._iffishTexture, Game.Instance, "Iffisch.png", 0, 0, 5, 3);

                PlayScene.this._enemyTextures = new Texture(512,512,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._blowFishEnemyTextureTile = TextureRegionFactory.createTiledFromAsset(PlayScene.this._enemyTextures, Game.Instance, "blowey.png", 0, 0, 1, 1);

                PlayScene.this._faerieTexture = new Texture(64,64,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._faerieTextureRegion = TextureRegionFactory.createFromAsset(PlayScene.this._faerieTexture,Game.Instance,"faerie.png",0,0);

                PlayScene.this._inGameFontTexture = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._respawnFont = FontFactory.createFromAsset(PlayScene.this._inGameFontTexture, Game.Instance, "ANDYB.TTF", 32, true, Color.WHITE);

                PlayScene.this._hudFontTexture = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._hudFont = FontFactory.createFromAsset(PlayScene.this._hudFontTexture, Game.Instance, "ANDYB.TTF", 24, true, Color.BLACK);

                PlayScene.this._analogControlTexture = new Texture(512,256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
                PlayScene.this._analogBGTextureRegion = TextureRegionFactory.createFromAsset(PlayScene.this._analogControlTexture, Game.Instance, "analogControls.png", 0, 0);
                PlayScene.this._analogStickTextureRegion = TextureRegionFactory.createFromAsset(PlayScene.this._analogControlTexture, Game.Instance, "analogStick.png", 0, 75);
                PlayScene.this._scoreHudTextureRegion = TextureRegionFactory.createFromAsset(PlayScene.this._analogControlTexture, Game.Instance, "scoreHud.png", 49, 75);

                PlayScene.this._engine.getTextureManager().loadTextures(_enemyTextures, _backgroundTexture, _iffishTexture, _faceTexture, _inGameFontTexture, _faerieTexture, _analogControlTexture, _hudFontTexture);
                PlayScene.this._engine.getFontManager().loadFonts(_respawnFont, _hudFont);
                 * 
                 */
                
                

                
            }

            @Override
            public void onComplete() {
                PlayScene.this.onLoadScene();
            }
        };

        new AsyncTaskLoader().execute(callback);

    }

	@Override
	protected void onLoadScene() {
		// set this as the main scene after loading
        this._engine.setScene(this);

		
	}

	@Override
	protected void unloadScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

}
