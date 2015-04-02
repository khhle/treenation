package com.treenation.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.treenation.utils.Constants;

public class WorldUtils {
	public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(Constants.GROUND_POSITION);
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUND_W, Constants.GROUND_H);
        body.createFixture(shape, 0);
        shape.dispose();
        return body;
    }
    
    public static Body createRunner(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(50, 50));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(100, 100);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, 0.5f);
        body.resetMassData();
        shape.dispose();
        return body;
    }
    
    public static Body createGold(World world) {
    	int tx = (int)(Math.random()*Constants.APP_WIDTH);
		int ty = (int)(Math.random()*Constants.APP_HEIGHT);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(200,200));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(20, 20);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, 0.5f);
        body.resetMassData();
        shape.dispose();
        return body;
    }
    
    public static Body createDynamicBody(World world,float x,float y, float w,float h) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(x,y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(w, h);
        Body body = world.createBody(bodyDef);
        //body.
        //body.setUserData(userdata);
        //BodyType bodyType = bType;
        body.createFixture(shape, 0.5f);
        body.resetMassData();
        shape.dispose();
        return body;
    }
    
    public static Body createStaticBody(World world,float x,float y, float w,float h) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(x,y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(w, h);
        body.createFixture(shape, 0);
        shape.dispose();
        return body;
    }
}
