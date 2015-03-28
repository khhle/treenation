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
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	
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
    	
    	myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 800, 600);
        
        batcher = new SpriteBatch();
        // Attach batcher to camera
        batcher.setProjectionMatrix(cam.combined);
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }
    
	 public void render(float runTime) {

	        // We will move these outside of the loop for performance later.
	        //Bird bird = myWorld.getBird();
		 	Tree tree = myWorld.getTree();
		 	Coin coin = myWorld.getCoin();
		 	coinHandler = myWorld.getCoinHandler();
	        // Fill the entire screen with black, to prevent potential flickering.
	        Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	        // Begin ShapeRenderer
	        shapeRenderer.begin(ShapeType.Filled);

	        // Draw Background color
	        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
	        shapeRenderer.rect(0, 0, 800, 600);

	        // Draw Grass
	        //shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
	        //shapeRenderer.rect(0, midPointY + 66, 136, 11);

	        // Draw Dirt
	        //shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
	        //shapeRenderer.rect(0, midPointY + 77, 136, 52);

	        // End ShapeRenderer
	        shapeRenderer.end();

	        // Begin SpriteBatch
	        batcher.begin();
	        // Disable transparency
	        // This is good for performance when drawing images that do not require
	        // transparency.
	        //batcher.disableBlending();
	        batcher.enableBlending();
	        batcher.draw(AssetLoader.bg, tree.getX(), tree.getY(), tree.getWidth(), tree.getWidth());

	        // The bird needs transparency, so we enable that again.
	        batcher.enableBlending();

	        // Draw bird at its coordinates. Retrieve the Animation object from
	        // AssetLoader
	        // Pass in the runTime variable to get the current frame.
	        drawCoin();
	        //batcher.draw(AssetLoader.coin_sprite,50, 50, coin.getWidth(), coin.getWidth());

	        // End SpriteBatch
	        batcher.end();

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
