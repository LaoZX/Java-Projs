import java.util.*;

public class MergeSort {
    static void Merge(int arr[], int left, int mid, int right){
        int n1 = mid - left;
        int n2 = right - mid;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];
        for(int i = 0; i < n1; i++) L[i] = arr[left+i];
        for(int j = 0; j < n2; j++) R[j] = arr[mid+j];

        L[n1] = R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = left; k < right; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } 
            else {
                arr[k] = R[j];
                j++;
            }
        }
    }

    static void mergeSort(int[] A, int left, int right){
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid, right);
            Merge(A, left, mid, right);
        }
    }

    public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		mergeSort(arr, 0, n);
		System.out.print(arr[0]);
		for (int i = 1; i < n; i++) {
			System.out.print(" " +arr[i]);
		}
    }
}
