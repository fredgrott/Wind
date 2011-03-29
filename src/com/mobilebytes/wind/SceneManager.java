package com.mobilebytes.wind;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.util.HorizontalAlign;

public class SceneManager {

     private MainActivity base;
	
	public SceneManager(MainActivity base) {
		this.base = base;
	}
	
	
	public void loadMain() {
		final Scene scene = new Scene(1);
		scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
		
        final Text textCenter = new Text(100, 60, base.mFont, "dis is the 2nd screen", HorizontalAlign.CENTER);
         scene.getLastChild().attachChild(textCenter);
        
        base.getEngine().setScene(scene);
	}
}
