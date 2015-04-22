package com.treenation.actor.building;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.treenation.bodydata.BodyType;

public class Tower extends ABuilding{
	public Tower(final Body body) {
		super(body);
		
		body.setLinearVelocity(0f, -100f);
		hp = 10;
		
		//replaced default sprite with actual sprite
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("tower.png")));
        
        
        
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, screenRectangle.x,screenRectangle.y);
        font.draw(batch, "Hp: " + hp, screenRectangle.x,screenRectangle.y);
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);

    }
}
