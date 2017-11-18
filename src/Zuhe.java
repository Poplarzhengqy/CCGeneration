
import java.util.Scanner;

public class Zuhe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] array = new int[n][2];
		int[] result = new int[n];
		for(int i=0; i<n; i++) {
			array[i][0] = scanner.nextInt();
			array[i][1] = scanner.nextInt();
			result[i] = helper(array[i][0], array[i][1]);
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
		
		scanner.close();
	}
	
	public static int helper(int n, int m) {
		int dinominator1 = 1;
		int dinominator2 = 1;
		int element = 1;
		
		for(int i=1; i<=n; i++) {
			element *= i;
		}
		
		for(int i=1; i<=m; i++) {
			dinominator1 *= i;
		}
		
		for(int i=1; i<=n-m; i++) {
			dinominator2 *= i;
		}
		
		return element / (dinominator1 * dinominator2);
	}
	
}
