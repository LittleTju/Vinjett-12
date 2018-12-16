package inkapsling;

public interface Operation {
	   public char getSymbol();
	   public int width(int rows, int cols);
	   public double evaluate(int op1, int op2);
}
