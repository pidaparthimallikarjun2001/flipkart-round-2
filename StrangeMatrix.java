import java.util.*;
public class StrangeMatrix {

    public static int firstPosition(int[][] arr, int rows, int cols, int target) {
        int low = 0, high = cols - 1;
        while(low <= high) {

            int mid = low  + (high / 2 - low / 2);

            if(arr[0][mid] == target && mid == 0) {
                return 0;
            }
            else if(arr[0][mid] == target && mid > 0 && arr[mid - 1] != arr[mid]) {
                return mid;
            }
            else if(arr[0][mid] >= target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return - 1;
    }

    public static int rowWithMaxOnes(int rows, int cols, int[][] arr) {
        int requiredRow = 0;
        int currentPosition = firstPosition(arr, rows, cols, 1);
        if(currentPosition == -1) {
            currentPosition = cols - 1;
        }

        for(int i = 0; i < rows; i++) {
            while(currentPosition >= 0 && arr[i][currentPosition] == 1) {
                currentPosition -= 1;
                requiredRow = i;
            }
        }
        return requiredRow;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[] numOfZeroesInARow = new int[rows];

        for(int i = 0; i < rows; i++) {
            numOfZeroesInARow[i] = sc.nextInt();
        }

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {

            int numberOfZeroes = numOfZeroesInARow[i];
            int numeberOfOnes = cols - numberOfZeroes;

            for(int j = 0; j < numberOfZeroes; j++) {
                arr[i][j] = 0;
            }
            for(int j = numberOfZeroes; j < cols; j++) {
                arr[i][j] = 1;
            }

        }

        System.out.println(rowWithMaxOnes(rows, cols, arr));
    }
}
