//Constant used in the game

package com.treenation.utils;

import com.badlogic.gdx.math.Vector2;


public class Constants {
	
	//App constant
	public static final int APP_WIDTH = 1280;
    public static final int APP_HEIGHT = 720;
    
    //In game variable
  	public static float TOTAL_GOLD = 0;
  	public static float TOTAL_ARMY = 0;
  	public static float TOTAL_HOUSE = 0;
    
    //World constant
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);
    
    
    //Ground constant
    public static final Vector2 GROUND_POSITION = new Vector2(0, 0);
    public static final float GROUND_W = 1280f;
    public static final float GROUND_H = 100f;
    
    //Coin constant
    public static final float GOLD_W = 20f;
    public static final float GOLD_H = 20f;
	public static float COIN_COUNT = 0;
	float gold_drop_time = 500;
	float gold_generate = 250;
	
	
	//Mine constant
	float cost_buy_mine = 5;
	float base_health_mine = 50;
	
	//Tower constant
	float cost_buy_tower = 10;
	float base_health_tower = 100;
	
	//Barrack constant
	float cost_buy_barrack = 15;
	float base_health_barrack = 100;
	
	//Wall constant
	float cost_buy_wall = 1;
	float base_health_wall = 150;
	
	//Warrior constant
	float cost_buy_warrior = 3;
	float base_health_warrior = 25;
	
	
	
	//Stuff
	float cost_to_upgrade = 10;

}
