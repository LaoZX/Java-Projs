import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int[] a = new int[h];
        for (int i = 0; i < h; i++) {
            a[i] = sc.nextInt();
        }

        HeapBottomUp(a);

        for (int i = 0; i < h; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void HeapBottomUp(int[] a) {
        int h = a.length;
        for (int i = h / 2; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    public static void maxHeapify(int[] a, int i) {
        int h = a.length;

        int left = i * 2 + 1;
        int right = left + 1;

        int largest;

        if (left < h && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < h && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest);
        }
    }
}
