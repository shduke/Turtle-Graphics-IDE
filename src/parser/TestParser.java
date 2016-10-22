package parser;

public class TestParser {

	public static void main(String[]args){
		InputParser test = new InputParser(); 
		System.out.println(test.getSymbol(":what"));
		System.out.println(test.getSymbol("what"));
		System.out.println(test.getSymbol("+"));
		System.out.println(test.getSymbol("2"));
		System.out.println(test.getSymbol("["));
		System.out.println(test.getSymbol("]"));
	}
	
	
}
