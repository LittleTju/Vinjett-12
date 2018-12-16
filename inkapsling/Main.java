package inkapsling;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int op1; //rows
		int op2; //cols
		Scanner in = new Scanner(System.in);
		System.out.println("Fyll i heltalet rows:");
		op1 = in.nextInt();
		System.out.println("Fyll i heltalet cols:");
		op2 = in.nextInt();
		in.close();
		
		Operation multi = new Operation(){ //anonym klass multi
			public char getSymbol() {
				return '*';
			}

			public int width(int rows, int cols) { //räknar ut bredden på våra kolumner
				int max = String.valueOf(rows * cols).length();
				return max;
			}

			public double evaluate(int op1, int op2) { //multiplikation
				return op1 * op2;
			}
		};
		
		Operation div = new Operation(){ //anonym klass div
			public char getSymbol() {
				return '/';
			}

			public int width(int rows, int cols) {
				int max = String.valueOf(rows/cols).length() + 3; //vi hanterar 2 decimaler
				return (int)max;
			}

			public double evaluate(int op1, int op2) {
				if(op2 != 0){ //odef för nämnare = 0
					return (double)op1/op2;
				}else{
					return 0; //kan ej returnera null för en double, så returnerar 0 när det är odefinierat
				}
			}
		};
		
		Operation add = new Operation(){ //anonym klass add
			public char getSymbol() {
				return '+';
			}

			public int width(int rows, int cols) {
				int max = String.valueOf(rows + cols).length();
				return max;
			}

			public double evaluate(int op1, int op2) {
				return op1 + op2;
			}
		};
		
		Operation sub = new Operation(){ //anonym klass sub
			public char getSymbol() { 
				return '-';
			}

			public int width(int rows, int cols) { //tar den längsta siffran
				int max1 = String.valueOf(rows).length();
				int max2 = String.valueOf(cols).length() + 1;
				if(max1 > max2){
					return max1;
				}else{
					return max2;
				}
			}

			public double evaluate(int op1, int op2) {
				return op1 - op2;
			}
		};
		
		ArithmeticTable Multi = new ArithmeticTable(multi, op1, op2);//skapar nytt ArithmeticTable
		Multi.print();//printar den
		
		ArithmeticTable Div = new ArithmeticTable(div, op1, op2);//skapar nytt ArithmeticTable
		Div.print();//printar den
		
		ArithmeticTable Add = new ArithmeticTable(add, op1, op2);//skapar nytt ArithmeticTable
		Add.print();//printar den
		
		ArithmeticTable Sub = new ArithmeticTable(sub, op1, op2);//skapar nytt ArithmeticTable
		Sub.print();//printar den
	}
}
