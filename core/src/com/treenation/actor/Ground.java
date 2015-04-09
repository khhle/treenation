package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.treenation.utils.Constants;


public class Ground extends GameActor {
	private final TextureRegion textureRegion;
	
	
    private Vector2 position;
    private float w;
    private float h;
	
	public Ground(Body body) {
		super(body);
		position = Constants.GROUND_POSITION;
		w = Constants.GROUND_W;
		h = Constants.GROUND_H;
		
		//replaced default sprite with actual sprite
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("ground.png")));
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, position.x, position.y, w,h);
    }

	

}