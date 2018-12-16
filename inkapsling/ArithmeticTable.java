package inkapsling;

import java.text.DecimalFormat;

public class ArithmeticTable {
	
	private int rows;
	private int cols;
	private Operation op; //t.ex. multi, div, add, sub
	
	public ArithmeticTable(Operation op, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.op = op;
	}
	
		//printar ut table
		public void print(){ 
			DecimalFormat structure = new DecimalFormat("#.##"); //Strukturen för våra tal

			System.out.format("%-"+ (String.valueOf(rows).length() + 1) + "s |", op.getSymbol()); //printar ut mellanslag motsvarande cols.length och printar |
			for(int i = 0; i < cols + 1; i++){ 
				System.out.format("%" + (op.width(rows, cols) + 1) + "d", i); //printar ut 0,1,2...cols med mellanslag motsvarande width() + 1
			}
			System.out.println(""); //ny rad
			//cols +1 för att det är antal luckor mellan varje siffra * width + 1 för att även siffran printas + längden av rows + 3(konstant)
			for(int i = 0; i <((cols + 1) * (op.width(rows, cols) + 1) + String.valueOf(rows).length() + 3); i++){ 
				System.out.print("-");
			}
			System.out.println(""); //ny rad
			for(int i = 0; i < (rows + 1); i++){
				System.out.format("%-"+ (String.valueOf(rows).length() + 1) + "d |", i); //printar ut i längst till vänster samt mellanslag
				
				for(int j = 0; j < (cols + 1); j++){ 
					System.out.format("%" + (op.width(rows, cols) + 1) + "s", structure.format(op.evaluate(i,j))); //printar ut rad för rad, i * j(rows*cols). 
				}
				System.out.println("");
			}
			System.out.println("");
		} 
}
