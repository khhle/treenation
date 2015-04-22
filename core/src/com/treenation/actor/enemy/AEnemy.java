package com.treenation.actor.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.treenation.actor.GameActor;
import com.treenation.bodydata.BodyType;
import com.treenation.utils.Constants;

public class AEnemy extends GameActor{
	private Animation runningAnimation;
	private float stateTime;
	protected int enemyType;

	public AEnemy(final Body body,int enemyType) {
		super(body);
		userData.setBodyType(BodyType.ENEMY);
		
		TextureRegion[] runningFrames = new TextureRegion[3];
		
		stateTime = 0f;
		this.enemyType = enemyType;
		
		switch (this.enemyType) {
	        case 1:  
	        	for (int i = 0; i < 3; i++) {
	                runningFrames[i] = new TextureRegion(new Texture(Gdx.files.internal("sprite/monster_0" + String.valueOf(i+4)+".png")));
	            }
	        	break;
	        
	        default: 
	        	for (int i = 0; i < 3; i++) {
	                runningFrames[i] = new TextureRegion(new Texture(Gdx.files.internal("sprite/monster_0" + String.valueOf(i+4)+".png")));
	            }
	        	break;
		}
		
		runningAnimation = new Animation(0.1f, runningFrames);
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                hp -= Constants.DEFAULT_TAP_DAMAGE;
            	
                return true;
            }
        });
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(runningAnimation.getKeyFrame(stateTime, true), screenRectangle.x, screenRectangle.y,screenRectangle.getWidth(), screenRectangle.getHeight());
        
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);
        if( hp < 0)
        {
            userData.setBodyType(BodyType.RECYCLE);
            userData.setDamge(0);
        }
        
    }
    
    
}
