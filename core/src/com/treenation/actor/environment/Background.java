package com.treenation.actor.environment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.treenation.utils.Constants;

public class Background extends Actor {

	//sprite of the background
    private final TextureRegion textureRegion;

    

    public Background() {
    	//find the background image file
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("bg.jpg")));
        
    }

    @Override
    public void act(float delta) {
        
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //draw the background at (0,0) with app's size
        batch.draw(textureRegion, 0, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        
    }



}