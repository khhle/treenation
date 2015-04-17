//Some helper function for body object

package com.treenation.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.treenation.bodydata.BodyType;
import com.treenation.bodydata.UserData;

public class BodyUtils {
	
	public static boolean bodyIsEnemy(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getBodyType() == BodyType.ENEMY;
    }
	
	public static boolean bodyIsHouse(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getBodyType() == BodyType.HOUSE;
    }
	
	
	public static boolean bodyIsRecyle(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getBodyType() == BodyType.RECYCLE;
    }
	
	public static BodyType getBodyType(Body body) {
        UserData userData = (UserData) body.getUserData();
        
        return userData.getBodyType();
    }
	
	//Check if the body is RECYCLE type
	//called by stage to delete un-used body
	public static boolean shouldRecycle(Body body) {
	 UserData userData = (UserData) body.getUserData();

     return userData.getBodyType() == BodyType.RECYCLE;
	}
}
