package com.treenation.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.treenation.gameobject.Coin;
import com.treenation.gameobject.CoinHandler;
import com.treenation.gameobject.Tree;
import com.treenation.helper.AssetLoader;

public class GameRenderer {
	
	private GameStage stage;
	private GameWorld myWorld;
	//private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	
	private int midPointX;
    private int midPointY;
    private int gameHeight;
	//private Vector2 touchedArea;
    private CoinHandler coinHandler;
	
	public GameRenderer(GameWorld world, int gameHeight, int midPointX) {
    	Gdx.app.log("GameRenderer", "contructor");
        
    	this.gameHeight = gameHeight;
        this.midPointX = midPointX;
    	
        stage = new GameStage();
        Gdx.input.setInputProcessor(stage);
    	myWorld = world;
        //cam = new OrthographicCamera();
        //cam.setToOrtho(true, 800, 600);
        
        //batcher = new SpriteBatch();
        // Attach batcher to camera
        //batcher.setProjectionMatrix(cam.combined);
        
        //shapeRenderer = new ShapeRenderer();
        //shapeRenderer.setProjectionMatrix(cam.combined);
    }
    
	 public void render(float runTime) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        stage.act(runTime);
        stage.draw();
        //stage.act(Gdx.graphics.getDeltaTime());

	 }
	 
	 private void drawCoin() {
		 for (Coin f : coinHandler.getList()) {
		 batcher.draw(AssetLoader.coin_sprite, 
				 f.getBounds().x,
				 f.getBounds().y,
				 f.getBounds().width,
				 f.getBounds().height);
		 }
	 }

	
}
