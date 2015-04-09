package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.treenation.game.Statistic;
import com.treenation.utils.Constants;
import com.treenation.utils.UserData;

public class House  extends GameActor {
	
	
	public House(final Body body) {
		super(body);
	
		body.setLinearVelocity(0f, -100f);
		
		//replaced default sprite with actual sprite
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("house1.png")));
        
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
        
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);
        
    }
}
