//Display the screen
//Call GameStage to display what's in the stage

package com.treenation.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{
	
	private GameStage stage;
	private float runTime = 0;
	
	public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");

        stage = new GameStage();
        Gdx.input.setInputProcessor(stage);
        
        
        
        
    }

    @Override
    public void render(float delta) {
    	runTime += delta;
    	stage.draw();
        stage.act(delta);
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
