package com.treenation.gameobject;

import com.badlogic.gdx.math.Vector2;

public class Tree {
	private Vector2 position;
	
	private int width;
	private int height;

	public Tree(float x, float y,int width,int height)
	{
		this.width = width;
        this.height = height;
        position = new Vector2(x, y);
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

    
}
