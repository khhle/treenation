package com.treenation.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
//import com.treenation.helper.AssetLoader;
import com.treenation.screen.GameScreen;


public class TreeNationGame extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Gdx.app.log("TreenationGame", "created");
		//AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
    public void dispose() {
        super.dispose();
        //AssetLoader.dispose();
    }
}
