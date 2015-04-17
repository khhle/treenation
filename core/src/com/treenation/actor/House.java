package com.treenation.actor;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.treenation.bodydata.BodyType;
import com.treenation.bodydata.UserData;
import com.treenation.utils.Constants;


public class House  extends GameActor {
	
	private float fake;
	public House(final Body body) {
		super(body);
		userData.setBodyType(BodyType.HOUSE);
		body.setLinearVelocity(0f, -100f);
		hp = 10;
		//replaced default sprite with actual sprite
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("house1.png")));
        
        
        fake = 0;
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
        if(userData.getIsDamage())
        {
        	ArrayList<UserData> tempList = userData.getList();
        	for (int i = 0; i < tempList.size(); i++) {
        		if(fake == 0)
        			hp -=tempList.get(i).getDamage();
        	}

        	//if(fake == 0)
        	//	hp--;
        	fake++;
        	if(fake > 10)
        		fake = 0;
        	
        	
        	//userData.setIsDamage(false);
        	//font.draw(batch, "Total gold: " + Constants.TOTAL_GOLD, 10, 50);
        	//Gdx.app.log("Test", String.valueOf(hp));
        	
        }
    }
    
    
}
