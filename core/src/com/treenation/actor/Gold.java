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
import com.treenation.bodydata.BodyType;
//import com.treenation.utils.ActorType;
import com.treenation.utils.Constants;



public class Gold extends GameActor {

	private boolean started; // testing stuff
	public boolean ist = false;
	public Gold(final Body body) {
		super(body);
		userData.setBodyType(BodyType.COIN);
		//set falling speed
		body.setLinearVelocity(0f, -100f);
		
		//replaced default sprite with actual sprite
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("coin.png")));

        
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((Gold)event.getTarget()).started = true; //testing stuff
            	//If click, set this body to Recycle type, so it will be remove in stage
                Constants.TOTAL_GOLD++;
                Constants.COIN_COUNT--;
                //body.setUserData(UserData.RECYCLE);
                userData.setBodyType(BodyType.RECYCLE);
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
        //if(started){
        //	setVisible(false);
        //}
    }
    
   

	

}
