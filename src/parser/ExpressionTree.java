package parser;

import java.util.ArrayList;
import java.util.List;

import node.Node;


public class ExpressionTree {

	private List<Node> myTree; 
	
	public ExpressionTree(){
		myTree = new ArrayList<>();
	}
	
	public void add(Node n){
		myTree.add(n);
	}
	
	public Node get(int index){
		return myTree.get(index);
	}
	
	@Override
	public String toString(){
		String toReturn = "";
		for(int i=0;i<myTree.size();i++){
			toReturn +=myTree.get(i)+"\n";
		}
		return toReturn; 
	}
	
	
	
}