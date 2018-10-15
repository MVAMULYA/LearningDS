import java.util.*;
public class Testing {


	public static void main(String args[] ) throws Exception {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter Array Size");
		int rowSize = s.nextInt();  
		int columnSize = s.nextInt(); 
		int[][] array = new int[rowSize][columnSize];
		int[][] arraynew = new int[columnSize][rowSize];
		System.out.println("Enter Array Elements row-wise ");   
		for (int i = 0 ; i<rowSize ; i++){
			for(int j=0 ; j< columnSize ; j++) {
				array[i][j] = s.nextInt();
			}

		}

		for (int i = 0 ; i<columnSize ; i++){
			for(int j=0 ; j< rowSize ; j++) {
				arraynew[i][j] = array[j][i];
			}

		}
		System.out.println("Original Array, ");

		for (int i = 0 ; i<rowSize ; i++){
			for(int j=0 ; j< columnSize ; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}

		System.out.println("Array Printed in reverse, ");

		for (int i = 0 ; i<columnSize ; i++){
			for(int j=0 ; j< rowSize ; j++) {
				System.out.print(arraynew[i][j] + "  ");
			}
			System.out.println();

		}
		s.close();

	}
}



