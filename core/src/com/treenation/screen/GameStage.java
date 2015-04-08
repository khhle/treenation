package com.treenation.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.treenation.actor.Background;
import com.treenation.actor.BuyButton;
import com.treenation.actor.Coin;
import com.treenation.actor.Ground;
import com.treenation.actor.House;
import com.treenation.actor.Runner;
import com.treenation.actor.Text;
import com.treenation.game.Statistic;
import com.treenation.utils.BodyUtils;
import com.treenation.utils.Constants;
import com.treenation.utils.UserData;
import com.treenation.utils.WorldUtils;



public class GameStage extends Stage {
	
	public static boolean addHouse = false;
    private World world;
    private Text text;
    private BuyButton buybutton;
    
    //private final float TIME_STEP = 1 / 600f;
    private float accumulator = 0f;
    private float coinTime = 0f;
    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    public GameStage() {
    	//Scaling.
    	super(new ScalingViewport(Scaling.fit, Constants.APP_WIDTH, Constants.APP_HEIGHT,new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));
    	world = WorldUtils.createWorld();
        addActor(new Background());
        addActor(new Ground(WorldUtils.createStaticBody(world,Constants.GROUND_POSITION.x,Constants.GROUND_POSITION.y,Constants.GROUND_W,Constants.GROUND_H)));
        
        addCoin(300,400,20,20);
        
        text = new Text();
        addActor(text);
        
        buybutton = new BuyButton(WorldUtils.createStaticBody(world,300,50,30,35));
        addActor(buybutton);
        
        
        
        renderer = new Box2DDebugRenderer();
        
        setupCamera();
    }

    private void setupCamera() {
    	camera = new OrthographicCamera();
        camera.setToOrtho( false, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        //camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        worldStep(delta);
        
 
        
        
        
        coinTime++;
        if(coinTime > 500 )
        {
        	if(Statistic.coin_count < 6){
        		addCoin(300,400,20,20);
        		Statistic.coin_count++;
        	}
        	coinTime = 0f;
        }
        
        if(addHouse){
        	addHouse(300,300,30,35);
            addHouse = false;
        }
       
        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);
        for (Body body : bodies) {
            update(body);
        }
        
        

    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }
    
    private void worldStep(float delta){
    	float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1/300f) {
            world.step(1/300f, 6, 2);
            accumulator -= 1/300f;
        }
    }
    
    private void update(Body body) {
    	if (BodyUtils.shouldRecycle(body) ) {
    		world.destroyBody(body);
        }
    }
    
    public void addHouse(float x,float y,float w,float h){
    	House house1 = new House(WorldUtils.createDynamicBody(world,x,y,w,h,UserData.HOUSE));
        house1.setName("house");
    	addActor(house1);
    }
    
    public void addCoin(float x,float y,float w,float h){
    	Coin mycoin3 = new Coin(WorldUtils.createDynamicBody(world,x,y,w,h,UserData.COIN));
    	mycoin3.setName("coin");
    	addActor(mycoin3);
    }
    
    
}
