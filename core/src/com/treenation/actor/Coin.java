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
//import com.treenation.utils.ActorType;
import com.treenation.utils.Constants;
import com.treenation.utils.UserData;


public class Coin extends GameActor {

	private boolean started; // testing stuff
	public boolean ist = false;
	public Coin(final Body body) {
		super(body);

		//set falling speed
		body.setLinearVelocity(0f, -100f);
		
		//replaced default sprite with actual sprite
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("coin.png")));

        
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((Coin)event.getTarget()).started = true; //testing stuff
            	//If click, set this body to Recycle type, so it will be remove in stage
                Statistic.total_gold++;
                Statistic.coin_count--;
                body.setUserData(UserData.RECYCLE);

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
        
        //testing stuff
        if(started){
        	setVisible(false);
        }
    }

	

}
