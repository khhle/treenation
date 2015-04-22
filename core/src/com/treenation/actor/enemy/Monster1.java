package com.treenation.actor.enemy;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.treenation.actor.GameActor;
import com.treenation.bodydata.BodyType;

public class Monster1 extends AEnemy{
	

	public Monster1(final Body body) {
		super(body,1);
		userData.setBodyType(BodyType.ENEMY);
		userData.setDamge(2);
		//set falling speed
		body.setLinearVelocity(-100f, 0f);
		

        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);
        
        
    }
}
