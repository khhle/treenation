//Some helper function for body object

package com.treenation.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;

public class BodyUtils {
	
	//Check if the body is RECYCLE type
	//called by stage to delete un-used body
	public static boolean shouldRecycle(Body body) {
	 UserData userData = (UserData) body.getUserData();

     return userData == UserData.RECYCLE;
	}
}
