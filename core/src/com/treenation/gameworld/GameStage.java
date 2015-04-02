package com.treenation.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.treenation.actor.Background;
import com.treenation.actor.Coin;
import com.treenation.actor.GameActor;
import com.treenation.actor.Ground;
import com.treenation.actor.Runner;
import com.treenation.game.Statistic;
import com.treenation.gameobject.WorldUtils;
import com.treenation.utils.BodyUtils;



public class GameStage extends Stage {
	// This will be our viewport measurements while working with the debug renderer
   // private static final int VIEWPORT_WIDTH = 20;
    //private static final int VIEWPORT_HEIGHT = 13;

    private World world;
    private Ground ground;
    private Runner runner;
    
    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;
    private float coinTime = 0f;
    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    public GameStage() {
        world = WorldUtils.createWorld();
        addActor(new Background());
        addActor(new Ground(WorldUtils.createGround(world)));
        Coin mycoin = new Coin(WorldUtils.createGold(world));
        Coin mycoin2 = new Coin(WorldUtils.createDynamicBody(world,150,300,20,20));
        mycoin.setTouchable(Touchable.enabled);
        //mycoin.setPosition(200,200);
        addActor(mycoin);
        addActor(mycoin2);
        //ground = new Ground(WorldUtils.createGround(world));
        runner = new Runner(WorldUtils.createRunner(world));
        renderer = new Box2DDebugRenderer();
        
        setupCamera();
    }

    private void setupCamera() {
    	camera = new OrthographicCamera();
        camera.setToOrtho( false, 800, 600);
        //camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Fixed timestep
        accumulator += delta;
        
        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
            
            
        }
        
        coinTime++;
        //Gdx.app.log("GameScreen", String.valueOf(delta));
        if(coinTime > 60 && Statistic.coin_count < 6)
        {
        	Coin mycoin3 = new Coin(WorldUtils.createDynamicBody(world,300,400,20,20));
        	mycoin3.setName("coin");
        	addActor(mycoin3);
        	//mycoin3.r
        	Statistic.coin_count++;
        	//world.destroyBody(mycoin3);
        	coinTime = 0f;
        }
        //TODO: Implement interpolation
        //world.
       
        Array<Actor> actorlist = getActors();
        //world.getBodies(bodies);

        for (Actor body : actorlist) {
            update( body);
        }

    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }
    
    private void update(Actor body) {
    	if(body.getName() == "coin") {
        Coin mbd = (Coin) body;
        if(mbd != null)
    	if (mbd.ist) {
        	Gdx.app.log("GameScreen", "destroyyy");
        	body.remove();
        }
    	}
    }
}
