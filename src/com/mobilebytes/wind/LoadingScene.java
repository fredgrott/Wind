package com.mobilebytes.wind;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class LoadingScene extends Scene {

	private final Engine _engine = null;

	public LoadingScene(int pLayerCount, Engine baseEngine) {
        super(pLayerCount);
    }

    // ===========================================================
    // Fields
    // ===========================================================

    private Texture _loadingTexture;

    private TiledTextureRegion _loadingTextureRegion;

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Inherited Methods
    // ===========================================================

    protected void onLoadResources() {
        TextureRegionFactory.setAssetBasePath("gfx/");

        _loadingTexture = new Texture(512, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        _loadingTextureRegion = TextureRegionFactory.createTiledFromAsset(_loadingTexture, Game.Instance, "loading.png", 0, 0, 2, 2);

        this._engine.getTextureManager().loadTexture(_loadingTexture);
    }

    protected void onLoadScene() {
        this.setBackground(new ColorBackground(1,1,1));

        AnimatedSprite loader = new AnimatedSprite(0, 0, _loadingTextureRegion);
        loader.setPosition((Game.CAMERA_WIDTH / 2) - (loader.getWidthScaled() / 2), (Game.CAMERA_HEIGHT / 2) - (loader.getHeightScaled() / 2));
        loader.animate(300, true);

        this.getLastChild().attachChild(loader);

        final PlayScene gameScene = new PlayScene(3,this._engine, null);
        gameScene.LoadResources(false);
    }

    protected void unloadScene() {}

    protected void onLoadComplete() {}
}
