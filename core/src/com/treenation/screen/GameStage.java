//All the actors are spawn in here


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
    	//Scaling the viewport to fit with all screen size but maintain aspect ratio
    	super(new ScalingViewport(Scaling.fit, Constants.APP_WIDTH, Constants.APP_HEIGHT,new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));
    	
    	//Creating the world to hold all actor
    	world = WorldUtils.createWorld();
    	
    	//Add background
        addActor(new Background());
        
        //Add ground platform
        addActor(new Ground(WorldUtils.createStaticBody(world,Constants.GROUND_POSITION.x,Constants.GROUND_POSITION.y,Constants.GROUND_W,Constants.GROUND_H)));
        
        //Add a test coin
        addCoin(300,400,20,20);
        
        //Add text to display how much coin has been collected
        text = new Text();
        addActor(text);
        
        //Add a test buy button
        //spawn a house when clicking
        buybutton = new BuyButton(WorldUtils.createStaticBody(world,300,50,30,35));
        addActor(buybutton);
        
        
        //Ask render to render debug boudary box around each actor
        renderer = new Box2DDebugRenderer();
        
        //Set up main camera
        setupCamera();
    }

    private void setupCamera() {
    	camera = new OrthographicCamera();
        camera.setToOrtho( false, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        //camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    //Call every frame
    //Handle all the action
    @Override
    public void act(float delta) {
        super.act(delta);
        worldStep(delta);
        
 
        
        
        //Logic to spawn coin
        coinTime++;
        if(coinTime > 500 )
        {
        	//The max number of coin on the screen is 6
        	if(Statistic.coin_count < 6){
        		addCoin(300,400,20,20);
        		Statistic.coin_count++;
        	}
        	coinTime = 0f;
        }
        
        //If player clicked on buyButton => spawn house
        if(addHouse){
        	addHouse(300,300,30,35);
            addHouse = false;
        }
       
        //Get all the physical bodies on the stage
        //And apply update
        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);
        for (Body body : bodies) {
            update(body);
        }
        
        

    }

    //Call every frame
    //Handle all the render
    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }
    
    //Stepping the world - required for box2d to work
    private void worldStep(float delta){
    	float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1/300f) {
            world.step(1/300f, 6, 2);
            accumulator -= 1/300f;
        }
    }
    
    //Logic to update each body
    private void update(Body body) {
    	if (BodyUtils.shouldRecycle(body) ) {
    		world.destroyBody(body);
        }
    }
    
    //Add house function
    //input: x, y position, width and heigh of sprite
    public void addHouse(float x,float y,float w,float h){
    	House house1 = new House(WorldUtils.createDynamicBody(world,x,y,w,h,UserData.HOUSE));
        house1.setName("house");
    	addActor(house1);
    }
    
    //Add coin function
    //input: x, y position, width and heigh of sprite
    public void addCoin(float x,float y,float w,float h){
    	Coin mycoin3 = new Coin(WorldUtils.createDynamicBody(world,x,y,w,h,UserData.COIN));
    	mycoin3.setName("coin");
    	addActor(mycoin3);
    }
    
    
}
