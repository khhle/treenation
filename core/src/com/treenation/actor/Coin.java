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
import com.treenation.utils.Constants;

public class Coin extends GameActor {
	//private final TextureRegion textureRegion;
	//private TextureRegion textureRegion;
	
	private Rectangle textureRegionBounds1;
	
    private Vector2 position;
    private float w;
    private float h;
	private boolean started;
	public Coin(Body body) {
		super(body);
		
		position = Constants.GROUND_POSITION;
		w = Constants.GROUND_W;
		h = Constants.GROUND_H;
		
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("coin.png")));
        //textureRegionL = new TextureRegion(new Texture(Gdx.files.internal("platform_l.png")));
        //textureRegionR = new TextureRegion(new Texture(Gdx.files.internal("platform_r.png")));
        textureRegionBounds1 = new Rectangle(position.x, position.y, w,h);
        //textureRegionBounds1 = new Rectangle(position.x, position.y+200, 192,101);
        //textureRegionBounds1 = new Rectangle(w-192, position.y+200, 192,101);
        Gdx.app.log("GameRenderer", String.valueOf(screenRectangle.x));
        Gdx.app.log("GameRenderer", String.valueOf(screenRectangle.y));
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((Coin)event.getTarget()).started = true;
                Gdx.app.log("GameRenderer", "hot");
                return true;
            }
        });
        
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //int i =  screenRectangle.x;
        batch.draw(textureRegion, screenRectangle.x,screenRectangle.y);
        //batch.draw(textureRegionL, position.x, position.y+200, 192,101);
        //batch.draw(textureRegionR, w-192, position.y+200, 192,101);
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);
        //Gdx.app.log("GameRenderer", String.valueOf(getX()));
       // Gdx.app.log("GameRenderer", String.valueOf(getY()));
        //Gdx.app.log("GameRenderer", String.valueOf(screenRectangle.x));
        //Gdx.app.log("GameRenderer", String.valueOf(screenRectangle.y));
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        if(started){
        	screenRectangle.x += 50;
        }
    }

}
