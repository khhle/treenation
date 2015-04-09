//Parent class
//All actor will be extended this class
//except background 

package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
//import com.treenation.utils.ActorType;


public abstract class GameActor extends Actor {

    protected Body body; //physical body of the actor
    protected Rectangle screenRectangle; //bounding region of the actor - used for box2d physic
    protected TextureRegion textureRegion; //sprite of the actor
    protected boolean isTouched;
    
    public GameActor(Body body) {
        this.body = body;
        
        isTouched = false;
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("error.png"))); //default sprite of actor
        screenRectangle = new Rectangle();
        
        //set bounding region - used for input listener
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        updateRectangle(); //update position of bouding region
        
        //update bounding
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }
    
    private void updateRectangle() {
        screenRectangle.x = body.getPosition().x-textureRegion.getRegionWidth()/2;
        screenRectangle.y = body.getPosition().y - textureRegion.getRegionHeight()/2;
        screenRectangle.width = textureRegion.getRegionWidth();
        screenRectangle.height = textureRegion.getRegionHeight();
    }
    
    public boolean getIsTouched(){
    	return isTouched;
    }

}
