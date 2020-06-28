package CodingDojang;

import java.util.Scanner;

public class ArrayQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int a2 = a;
		int b2 = b;
		int z = 0;
		int z2 = 1;
		int i = 0, j = 0;
		int sw = 0;
		int count = 0;
		int [][] result = new int [a][b];
		
		while(true) {
			if(sw == 0) {
				
				result[i][j] = count;
				count++;
			     j++;
				if(j == b - 1) {
					sw = 1;
					b -= 1;
				}
			}
			else if(sw == 1) {
				result[i][j] = count;
				count++;
				i++;
				if(i == a - 1) {
					sw = 2;
					a -= 1;
				}
			}
			else if(sw == 2) {
				result[i][j] = count;
				count++;
				j--;
				if(j == z) {
					sw = 3;
					z += 1;
				}
			}
			else if(sw == 3) {
				result[i][j] = count;
				count++;
				i--;
				if(i == z2) {
					sw = 0;
					z2 += 1;
				}
			}

			if(count == a2 * b2)
			break;
		}
		
		for(int i2 = 0; i2 < a2; i2++) {
			for(int j2 = 0; j2 < b2; j2++) {			
				System.out.print(result[i2][j2]+"    ");
			}
			System.out.println();
		}
	}
}