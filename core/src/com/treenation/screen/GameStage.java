//All the actors are spawn in here


package com.treenation.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.treenation.actor.Gold;
import com.treenation.actor.Text;
import com.treenation.actor.building.Mine;
import com.treenation.actor.button.BuyButton;
import com.treenation.actor.enemy.Monster1;
import com.treenation.actor.environment.Background;
import com.treenation.actor.environment.Ground;
import com.treenation.bodydata.UserData;
import com.treenation.utils.BodyUtils;
import com.treenation.utils.Constants;
import com.treenation.utils.WorldUtils;



public class GameStage extends Stage implements ContactListener{
	
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
    	world.setContactListener(this);
    	//Add background
        addActor(new Background());
        
        //Add ground platform
        addActor(new Ground(WorldUtils.createStaticBody(world,Constants.GROUND_POSITION.x,Constants.GROUND_POSITION.y,Constants.GROUND_W,Constants.GROUND_H)));
        
        //Add a test coin
        addCoin(500,600,20,20);
        
        
        Monster1 emy = new Monster1(WorldUtils.createDynamicBody(world,1300,150,30,30));
        addActor(emy);
        
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
        if(coinTime > 200 )
        {
        	//limit the max number of coin on the screen is 6
        	if(Constants.COIN_COUNT < 6){
        		int random_num = (int)(Math.random()*Constants.APP_WIDTH);
        		//drop coin to random x-position,y=720
        		addCoin(random_num,720,20,20);
        		Constants.COIN_COUNT++;
        	}
        	coinTime = 0f;
        }
        
        //If player clicked on buyButton => spawn house
        if(addHouse){
        	addHouse(300,150,30,35);
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
    
    
    @Override
    public void beginContact(Contact contact) {
    	//Gdx.app.log("GameScreen", "col");
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();
        UserData temp;
        UserData temp2;
        //Gdx.app.log("GameScreen", "col");
        if ((BodyUtils.bodyIsHouse(a) && BodyUtils.bodyIsEnemy(b)) ||
                (BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsHouse(b))) {
        	//Gdx.app.log("GameScreen", "collide");
        	if(BodyUtils.bodyIsHouse(a))
            {
        		Gdx.app.log("GameScreen", "collide");
            	temp = (UserData)a.getUserData();
            	temp2 = (UserData)b.getUserData();
            	temp.setIsDamage(true);
            	temp.addDamageToList(temp2);
            	a.setUserData(temp);
            }
            if(BodyUtils.bodyIsHouse(b))
            {
            	Gdx.app.log("GameScreen", "collide");
            	temp = (UserData)b.getUserData();
            	temp2 = (UserData)a.getUserData();
            	temp.setIsDamage(true);
            	temp.addDamageToList(temp2);
            	b.setUserData(temp);
            }
        } 
        

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
    	Mine house1 = new Mine(WorldUtils.createStaticBody(world,x,y,w,h));
        house1.setName("house");
    	addActor(house1);
    }
    
    //Add coin function
    //input: x, y position, width and heigh of sprite
    public void addCoin(float x,float y,float w,float h){
    	Gold mycoin3 = new Gold(WorldUtils.createDynamicBody(world,x,y,w,h));
    	mycoin3.setName("coin");
    	addActor(mycoin3);
    }

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
        
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}
    
    
}
