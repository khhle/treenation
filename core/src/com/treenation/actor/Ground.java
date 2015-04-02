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
	//private final TextureRegion textureRegionL;
	//private final TextureRegion textureRegionR;
	
	private Rectangle textureRegionBounds1;
	//private Rectangle textureRegionBounds2;
	//private Rectangle textureRegionBounds3;
    private Vector2 position;
    private float w;
    private float h;
	
	public Ground(Body body) {
		super(body);
		position = Constants.GROUND_POSITION;
		w = Constants.GROUND_W;
		h = Constants.GROUND_H;
		
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("ground.png")));
        //textureRegionL = new TextureRegion(new Texture(Gdx.files.internal("platform_l.png")));
        //textureRegionR = new TextureRegion(new Texture(Gdx.files.internal("platform_r.png")));
        textureRegionBounds1 = new Rectangle(position.x, position.y, w,h);
        //textureRegionBounds1 = new Rectangle(position.x, position.y+200, 192,101);
        //textureRegionBounds1 = new Rectangle(w-192, position.y+200, 192,101);
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, position.x, position.y, w,h);
        //batch.draw(textureRegionL, position.x, position.y+200, 192,101);
        //batch.draw(textureRegionR, w-192, position.y+200, 192,101);
    }

	

}