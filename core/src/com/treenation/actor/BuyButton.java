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
import com.treenation.screen.GameStage;
import com.treenation.utils.Constants;

public class BuyButton extends GameActor {

	
	public BuyButton(final Body body) {
		super(body);
		
		
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("buy.png")));
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Statistic.total_gold--;
                GameStage.addHouse = true;
                
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
        
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
       
    }
}
