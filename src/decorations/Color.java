package decorations;

public class Color {

	private static final String reset = "\u001B[0m";
	private static final String green = "\u001B[32m";
	private static final String red = "\u001B[31m";
	private static final String yellow = "\u001B[33m";
	
	public static String yellow() {
		return yellow;
	}
	
	public static String reset() {
		return reset;
	}
	
	public static String green() {
		return green;
	}
	
	public static String red() {
		return red;
	}
	
}
