package parser;

import java.util.ArrayList;
import java.util.List;

import command.AbstractCommand;
import node.Node;


public class ExpressionTree {

	private Node myRoot; 
	//add map to only things that need it -> variable, operation HashMap<String, VariableCommand> myMap
	
	
	public ExpressionTree(){
		myRoot = null; 
	}
	
	public void add(Node n){
		if(myRoot==null){
			myRoot = n; 
			return; 
		}
		Node temp = myRoot; 
		while(temp.myNext!=null){
			temp = temp.myNext; 
		}
		temp.myNext = n; 
	}
	
	public AbstractCommand createCommand(){
		return myRoot.createCommand();
	}
	
	@Override
	public String toString(){
		Node temp = myRoot;
		String printing = "";
		while(temp!=null){
			printing +=temp.toString()+"\n";
			temp=temp.myNext;
		}
		return printing; 
	}
	
	
}