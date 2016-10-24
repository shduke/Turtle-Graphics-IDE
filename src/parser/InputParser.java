package parser;

import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import cursor.Cursor;
import node.BracketNode;
import node.ConstantNode;
import node.CursorNode;
import node.Node;
import node.OperationNode;
import node.VariableNode;
import view.AppResources;

public class InputParser {
	 private List<Entry<String, Pattern>> mySymbols;
	 private List<String> myMethodNames; 
	 private ResourceBundle myCursorSyntax, myOperationSyntax;
	 
     public InputParser () {
         mySymbols = new ArrayList<>();
         myMethodNames = new ArrayList<>(); 
         addPatterns(AppResources.PATTERNS_STRING.getResource());//hardcoded probably need to change
         myCursorSyntax = ResourceBundle.getBundle("cursor");//hardcoded probably need to change
         myOperationSyntax = ResourceBundle.getBundle("operations");//hardcoded probably need to change
     }
 
     // adds the given resource file to this language's recognized types
     public void addPatterns (String syntax) {
         ResourceBundle resources = ResourceBundle.getBundle(syntax);
         Enumeration<String> iter = resources.getKeys();
         while (iter.hasMoreElements()) {
             String key = iter.nextElement();
             String regex = resources.getString(key);
             mySymbols.add(new SimpleEntry<>(key,
                            // THIS IS THE IMPORTANT LINE
                            Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
         }
     }
     
     public ExpressionTree parse(String input,Cursor cursor){
    	 String[]split = input.split("\\s+");
    	 ExpressionTree construct = new ExpressionTree(); 
    	 for(int i=0;i<split.length;i++){
    		 if(getSymbol(split[i]).equals("COMMAND")){
    			 if(myCursorSyntax.containsKey(split[i])){
    				 construct.add(new CursorNode(split[i],cursor));
    			 }
    			 else if(myOperationSyntax.containsKey(split[i])){
    				 construct.add(new OperationNode(split[i],construct.getMap()));
    			 }
    			 else if(!myMethodNames.contains(split[i])){
    				 construct.add(new VariableNode("variable",split[i],null));
    				 myMethodNames.add(split[i]);
    			 }
    			 else if(myMethodNames.contains(split[i])){
    				 construct.add(new OperationNode(split[i],construct.getMap()));
    			 }
    		 }
    		 else if(getSymbol(split[i]).equals("RIGHTBRACKET")||getSymbol(split[i]).equals("LEFTBRACKET")){
    			 construct.add(new BracketNode(split[i]));
    		 }
    		 else if(getSymbol(split[i]).equals("CONSTANT")){
    			 construct.add(new ConstantNode("constant",Double.parseDouble(split[i])));
    		 }
    		 else if(getSymbol(split[i]).equals("VARIABLE")){
    			 construct.add(new VariableNode("variable",split[i],null));   			
    		 }
    	 }
    	 
    	 return construct; 
     }
 
     // returns the language's type associated with the given text if one exists 
     public String getSymbol (String text) {
         final String ERROR = AppResources.ERROR_STRING.getResource();
         for (Entry<String, Pattern> e : mySymbols) {
             if (match(text, e.getValue())) {
                 return e.getKey();
             }
         }
         
         return ERROR;
     }
 
     // returns true if the given text matches the given regular expression pattern
     private boolean match (String text, Pattern regex) {
         // THIS IS THE KEY LINE
         return regex.matcher(text).matches();
     }
}