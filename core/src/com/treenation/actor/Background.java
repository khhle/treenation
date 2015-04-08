package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.treenation.utils.Constants;

public class Background extends Actor {

    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds;

    

    public Background() {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("bg.jpg")));
        textureRegionBounds = new Rectangle(0, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        
    }

    @Override
    public void act(float delta) {
        
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, textureRegionBounds.x, textureRegionBounds.y, textureRegionBounds.width,textureRegionBounds.height);
        
    }



}