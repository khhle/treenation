//Parent class
//All actor will be extended this class
//except background 

package com.treenation.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.treenation.bodydata.BodyType;
//import com.treenation.utils.ActorType;
import com.treenation.bodydata.UserData;


public abstract class GameActor extends Actor {

    protected Body body; //physical body of the actor
    protected UserData userData;
    protected Rectangle screenRectangle; //bounding region of the actor - used for box2d physic
    protected TextureRegion textureRegion; //sprite of the actor
    protected boolean isTouched;
    protected float hp;
    protected BitmapFont font;
    
    public GameActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
        //userData.setBodyType(BodyType.DEFAULT);
        hp = 10;
        isTouched = false;
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("error.png"))); //default sprite of actor
        screenRectangle = new Rectangle();
        
        font = new BitmapFont();
        font.setScale(1.5f);
        font.setColor(255f,255f,255,1);   
        //set bounding region - used for input listener
        setBounds(screenRectangle.x,screenRectangle.y,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
        if (body.getUserData() != null) {
            updateRectangle();//update position of bouding region
        } else {
            // This means the world destroyed the body (enemy or runner went out of bounds)
            remove();
        }
       
        
        if(hp < 0){
        	userData.setBodyType(BodyType.RECYCLE);
        	remove();
        }
        
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
    
    public UserData getUserData(){
    	return userData;
    }
    
    public float getHp(){
    	return hp;
    }

}
