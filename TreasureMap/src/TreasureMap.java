import java.util.Scanner;
import java.util.*;

public class TreasureMap{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Map Size");
		int size = sc.nextInt();

		System.out.println("Dificulty");
		int difi = sc.nextInt();

		int[][] newMap = createMap(size, difi);

		printMap(newMap);
		checkMap(newMap);
	}

	public static int[][] createMap(int size, int difi){
		int [][] array = new int[size][size];	//Bidimesional map
		String clue;
/*------Array fill----------------*/

		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++) {
				clue = Integer.toString(i+1) + Integer.toString(j+1);
				array[i][j] = Integer.parseInt(clue);
			}	
		} 

		//temp = array[0][0]; //treasure
		array[0][0] = array[2][3];
		array[2][3] = array[0][1];
		array[0][1] = array[1][3];
		array[1][3] = array[3][0];	//Treasure
		//array[3][0] = temp;

/*----------------------------------*/

		return array;
	}


	public static void checkMap(int[][] array){
		boolean found = false;
		int currentCellRow = 0;
		int currentCellCol = 0;

		while(!found){
			System.out.println("Currently in row "+(currentCellRow+1)+" col "+(currentCellCol+1));
			
			String value = Integer.toString(array[currentCellRow][currentCellCol]); //Starts at [0][0]
			String[] arrVal = value.split("");

			int nextCellRow = Integer.parseInt(arrVal[0])-1; 
			int nextCellCol = Integer.parseInt(arrVal[1])-1; 

			System.out.println("Next Row " + (nextCellRow+1) +" next col " + (nextCellCol+1) );
			/*System.out.print(nextCellRow);
			System.out.println(nextCellCol);*/

			if(nextCellCol==currentCellCol && nextCellRow==currentCellRow){
				System.out.println("Treasure found");
				found = true;
			}
			else{
				currentCellCol = nextCellCol;
				currentCellRow = nextCellRow;
			}
		}
	}

	public static void printMap(int[][] array){		//Almost done fix last part array
		
		System.out.print("+");
		for (int k = 0; k<array.length*5-1; k++) {	//(Numero del tamaño del array * 5) -1 top
			System.out.print("-");
		}
		System.out.println("+");

		for (int i = 0; i<array.length; i++) {

			for (int j = 0; j<array[i].length; j++) {
				System.out.print("| "+ array[i][j] + " ");
			}
			System.out.println("|");

			
			for (int k = 0; k<array[i].length; k++) {	//(length array * 5) -1 down //Fix!!!!!!!!!!!!!!!!!
				System.out.print("+----");
			}
			System.out.println("+");


		}

		/*System.out.print("+");
		for (int k = 0; k<array.length*5-1; k++) {		//(Numero del tamaño del array * 5) -1 down
			System.out.print("-");
		}
		System.out.println("+");*/
	}
}