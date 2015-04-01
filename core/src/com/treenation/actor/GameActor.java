package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameActor extends Actor {

    protected Body body;
    protected Rectangle screenRectangle;
    protected TextureRegion textureRegion;
    
    public GameActor(Body body) {
        this.body = body;
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("error.png")));
        screenRectangle = new Rectangle();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        updateRectangle();

    }
    
    private void updateRectangle() {
        screenRectangle.x = body.getPosition().x-textureRegion.getRegionWidth()/2;
        screenRectangle.y = body.getPosition().y - textureRegion.getRegionHeight()/2;
        //body.
        screenRectangle.width = textureRegion.getRegionWidth();
        screenRectangle.height = textureRegion.getRegionHeight();
    }
}
