package exception;

public class SyntaxException extends Exception {

	public SyntaxException(String message){
		super(message);
	}
	
	public SyntaxException(Throwable cause ){
		super(cause);
	}
	
}
