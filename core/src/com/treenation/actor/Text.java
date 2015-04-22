package com.treenation.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.treenation.utils.Constants;


public class Text extends Actor {

    BitmapFont font;
    
    public Text(){
        font = new BitmapFont();
        font.setScale(2);
        font.setColor(255f,255f,255,1);   
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
         font.draw(batch, "Total gold: " + Constants.TOTAL_GOLD, 10, 50);
         //Also remember that an actor uses local coordinates for drawing within
         //itself!
    }

    

}
