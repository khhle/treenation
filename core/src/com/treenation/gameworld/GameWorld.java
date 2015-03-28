package com.treenation.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.treenation.gameobject.Coin;
import com.treenation.gameobject.CoinHandler;
import com.treenation.gameobject.Tree;

public class GameWorld {
	private Tree tree;
	private Coin coin;
	private CoinHandler coinHandler;
	private Vector2 touchedArea;
	private float timeCoin = 0;
	private boolean isTouch = false;
	private boolean check = false;
	
	public GameWorld(int midPointX) {
		Gdx.app.log("GameWorld", "construtor");
		tree = new Tree(midPointX-250,100, 500, 500);
		coinHandler = new CoinHandler();
    }
	
	public void update(float delta) {
		//tree.update(delta);
		timeCoin += delta;
		if(timeCoin > 1 )
		{
			//Gdx.app.log("GameWorld", "coin");
			check  = true;
			int tx = (int)(Math.random()*Gdx.graphics.getWidth());
			int ty = (int)(Math.random()*Gdx.graphics.getHeight());
			coinHandler.addCoin(new Vector2(tx,ty));
			//Gdx.app.log("GameWorld", String.valueOf(tx));
			//Gdx.app.log("GameWorld", String.valueOf(ty));
			timeCoin = 0;
		}
		
		if(isTouch){
			//Gdx.app.log("GameWorld", "touch");
			//Gdx.app.log("GameWorld", String.valueOf(touchedArea.x));
			//Gdx.app.log("GameWorld", String.valueOf(touchedArea.y));
			ArrayList<Coin> tempList = coinHandler.getList();
			 for (int i = 0; i < tempList.size(); i++) {
				 Coin tempCoin = tempList.get(i);
				 if (touchedArea.x >= tempCoin.getBounds().x && 
				 touchedArea.x <= tempCoin.getBounds().x+tempCoin.getBounds().width &&
				 touchedArea.y >= tempCoin.getBounds().y && 
				 touchedArea.y <= tempCoin.getBounds().y+tempCoin.getBounds().height) {
					 tempList.remove(i);
					 //Gdx.app.log("GameWorld", "touch coin");
				 }
			 }
			 coinHandler.setList(tempList);
			 isTouch = false;
		}
		
    }
	
	public Tree getTree() {
        return tree;
    }
	
	public Coin getCoin() {
        return coin;

    }
	
	public CoinHandler getCoinHandler(){
		return coinHandler;
	}
	
	public void setTouchedArea(Vector2 area) {
		this.touchedArea = area;
		isTouch = true;
	}
}
