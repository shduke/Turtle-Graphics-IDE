package parser;

import java.util.HashMap;

import command.utility.IVariable;

public class TestParser {

	public static void main(String[]args){
		HashMap<String,IVariable> testMap = new HashMap<>(); 
		InputParser test = new InputParser("english",testMap); 
		System.out.println(test.getSymbol(":what"));
		System.out.println(test.getSymbol("what"));
		System.out.println(test.getSymbol("+"));
		System.out.println(test.getSymbol("2"));
		System.out.println(test.getSymbol("["));
		System.out.println(test.getSymbol("]"));
	}
	
	
}