package node;

import turtle.Turtle;

public class CursorNode extends Node {

	private Turtle myTurtle;
	
	public CursorNode(String type,Turtle turtle){
		super(type);
		myTurtle=turtle;
	}
	
	public Turtle getTurtle(){
		return myTurtle; 
	}
	
	public String toString(){
		return "CursorNode" +"{"+this.getType()+"}";
	}
	
}
