package com.treenation.bodydata;

import java.util.ArrayList;

public class UserData {
	public BodyType bodyType;
    public float width;
    public float height;
    
    private boolean isDamage;
    private float damage;
    private ArrayList<UserData> damageList;
    
    public UserData() {
    	isDamage = false;
    	damageList = new ArrayList<UserData>();
    	bodyType = BodyType.DEFAULT;
    }

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public BodyType getBodyType() {
        return bodyType;
    }
    
    public void setBodyType(BodyType dataType){
    	bodyType = dataType;
    }
    
    

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
    public void setIsDamage(boolean isDamage){
    	this.isDamage = isDamage;
    }
    
    public boolean getIsDamage(){
    	return this.isDamage;
    }
    
    public void setDamge(float nnew){
    	damage = nnew;
    }
    
    public float getDamage(){
    	return damage;
    }
    
    public ArrayList<UserData> getList() {
    		 return damageList;
	}
    public void addDamage(UserData nnew) {
    			 damageList.add(nnew);
	}
}
