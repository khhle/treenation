package com.treenation.gameobject;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class CoinHandler {
	private ArrayList<Coin> coinList;
	
	public CoinHandler(){
		coinList = new ArrayList<Coin>();
	}
	
	public ArrayList<Coin> getList() {
		 return coinList;
	}
	
	
	public void setList(ArrayList<Coin> coinList) {
		 this.coinList = coinList;
	}
	
	public void addCoin(Vector2 position) {
		 coinList.add(new Coin(position));
	}
}
