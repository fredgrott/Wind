package com.mobilebytes.wind;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;


public abstract class GameScene extends Scene {

	
	protected Engine _engine;

    public GameScene(int pLayerCount, Engine baseEngine) {
        super(pLayerCount);
        _engine = baseEngine;
    }

    // ===========================================================
    // Inherited Methods
    // ===========================================================

    protected abstract void onLoadResources();

    protected abstract void onLoadScene();

    protected abstract void unloadScene();

    protected abstract void onLoadComplete();

    // ===========================================================
    // Methods
    // ===========================================================

    public void LoadResources(boolean loadSceneAutomatically){
        this.onLoadResources();
        if(loadSceneAutomatically){
            this.onLoadScene();
        }
    }

    public void LoadScene(){
        this.onLoadScene();
    }
}