package javaapplication1.models;

import java.util.Random;


public abstract class Being{
        private String name;
	private int code;

	public Being(String name){
		this.name = name;
                this.code = new Random().nextInt(999999);
	}

	public String getName(){
		return name;
	}
	public int getCode(){
		return code;
	}

	@Override
	public String toString(){
		return "Name: " + name + " |  Code: " + code;
	}
}