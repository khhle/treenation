package com.treenation.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;

public class BodyUtils {
	public static boolean shouldRecycle(Body body) {
	 UserData userData = (UserData) body.getUserData();

     return userData == UserData.RECYCLE;
	}
}
