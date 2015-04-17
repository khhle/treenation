package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.treenation.bodydata.BodyType;
import com.treenation.utils.Constants;

public class Enemy extends GameActor{
	private Animation runningAnimation;
	private float stateTime;

	public Enemy(final Body body) {
		super(body);
		userData.setBodyType(BodyType.ENEMY);
		userData.setDamge(2);
		//set falling speed
		body.setLinearVelocity(-100f, 0f);
		
		//TextureAtlas textureAtlas = new TextureAtlas("monster.txt");
		TextureRegion[] runningFrames = new TextureRegion[3];
		//runningFrames = texture
		for (int i = 0; i < 3; i++) {
            //String path = Constants.RUNNER_RUNNING_REGION_NAMES[i];
            runningFrames[i] = new TextureRegion(new Texture(Gdx.files.internal("sprite/monster_0" + String.valueOf(i+4)+".png")));
        }
		runningAnimation = new Animation(0.1f, runningFrames);
		stateTime = 0f;
		//replaced default sprite with actual sprite
        //textureRegion = new TextureRegion(new Texture(Gdx.files.internal("coin.png")));

        
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                isTouched = true;
                userData.setBodyType(BodyType.RECYCLE);
                userData.setDamge(0);

                return true;
            }
        });
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //batch.draw(textureRegion, screenRectangle.x,screenRectangle.y);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(runningAnimation.getKeyFrame(stateTime, true), screenRectangle.x, screenRectangle.y,screenRectangle.getWidth(), screenRectangle.getHeight());
        if(isTouched)
        	font.draw(batch, "Dead", screenRectangle.x,screenRectangle.y);
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);
        
        
    }
    
    
}
