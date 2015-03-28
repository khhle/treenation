package com.treenation.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.treenation.gameobject.Coin;
import com.treenation.gameworld.GameRenderer;
import com.treenation.gameworld.GameWorld;


public class InputHandler implements InputProcessor {
	//private Coin myCoin;
	private GameRenderer renderer;
	private GameWorld world;
	
	public InputHandler(GameWorld world) {
        // myBird now represents the gameWorld's bird.
        this.world = world;
    }
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//myCoin.onClick();
		world.setTouchedArea(new Vector2(screenX, screenY));
        return true; // Return true to say we handled the touch.
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	world.setTouchedArea(new Vector2(-100.0f, -100.0f));
		return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
