package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import command.AbstractCommand;
import command.ICommand;
import command.utility.IVariable;
import command.utility.Variable;
import exception.SyntaxException;
import node.INode;
import node.Node;
import node.NodeIterator;

public class ExpressionTree {

	private Node myRoot;

	public ExpressionTree() {
		myRoot = null;
	}

	public String get(int index){
		Node temp = myRoot; 
		int count = 0;
		while(myRoot!=null){
			if(count == index){
				return temp.getType();
			}
			temp=temp.myNext;
			count++;
		}
		return null; 
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

	public ICommand createCommand() throws SyntaxException {
		INode iteratedNode = new NodeIterator(myRoot);
		return myRoot.createCommand(iteratedNode);
	}

	@Override
	public String toString() {
		Node temp = myRoot;
		String printing = "";
		while (temp != null) {
			printing += temp.toString() + "\n";
			temp = temp.myNext;
		}
		return printing;
	}

}