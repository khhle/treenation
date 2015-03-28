package com.treenation.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
	private static final float SIZE = 1.f;
	private Vector2 position;
	
	private int width;
	private int height;
	
	private Rectangle bounds = new Rectangle();
	
	public Coin(Vector2 position)
	{
		//this.width = width;
        //this.height = height;
        //position = new Vector2(x, y);
        bounds.x = position.x;
        bounds.y = position.y;
        bounds.width = SIZE * Gdx.graphics.getPpcX();
        bounds.height = SIZE * Gdx.graphics.getPpcY();
	}
	
	public void update(float delta) {

       

    }

    public void onClick() {
        
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    
    public Rectangle getBounds() {
    	 return bounds;
    }
}
