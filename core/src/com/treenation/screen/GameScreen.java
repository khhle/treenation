package com.treenation.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.treenation.gameworld.GameRenderer;
import com.treenation.gameworld.GameWorld;
import com.treenation.helper.InputHandler;

public class GameScreen implements Screen{
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime = 0;
	
	public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 800;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointX = (int) (gameWidth / 2);
        int midPointY = (int) (gameHeight / 2);
        //Gdx.app.log("GameScreen", String.valueOf(gameWidth));
        //Gdx.app.log("GameScreen", String.valueOf(gameHeight));
        
        world = new GameWorld(midPointX); // initialize world
        renderer = new GameRenderer(world, (int) gameHeight, midPointX); // initialize renderer
        //Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void render(float delta) {
    	runTime += delta;
    	world.update(delta); // GameWorld updates 
    	renderer.render(runTime); // GameRenderer renders
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");     
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");        
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");       
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
