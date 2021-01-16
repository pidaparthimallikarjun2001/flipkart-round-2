import java.util.*;
public class WaveArray {

    public static void convertToWave(int[] arr, int n) {
        for(int i = 0; i < n - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        convertToWave(arr, n);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
