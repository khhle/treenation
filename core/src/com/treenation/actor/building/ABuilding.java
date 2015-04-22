package com.treenation.actor.building;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.treenation.actor.GameActor;
import com.treenation.bodydata.BodyType;
import com.treenation.bodydata.UserData;


public class ABuilding  extends GameActor {
	

	private float damgeTakenCoolDown;
	public ABuilding(final Body body) {
		super(body);
		userData.setBodyType(BodyType.HOUSE);
		
		
        damgeTakenCoolDown = 0;
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);
        if(userData.getIsDamage())
        {
        	ArrayList<UserData> tempList = userData.getDamageList();
        	for (int i = 0; i < tempList.size(); i++) {
        		if(damgeTakenCoolDown == 0)
        			hp -=tempList.get(i).getDamage();
        	}

        	damgeTakenCoolDown++;
        	if(damgeTakenCoolDown > 10)
        		damgeTakenCoolDown = 0;
	
        }
    }
    
    
}
