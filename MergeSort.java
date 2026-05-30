import java.util.*;

public class MergeSort {
    private int[] a;

    void input() {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Enter total numbers:");
        int n = sc.nextInt();

        a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = rm.nextInt(1000);
    }

    void display() {
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
    }

    void sort() {
        mergesort(0, a.length - 1);
    }

    void mergesort(int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;

        mergesort(left, mid);
        mergesort(mid + 1, right);
        merge(left, mid, right);
    }

    void merge(int left, int mid, int right) {
        int temp[] = new int[a.length];

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= right)
            temp[k++] = a[j++];

        for (i = left; i <= right; i++)
            a[i] = temp[i];
    }

    public static void main(String args[]) {
        MergeSort ob = new MergeSort();

        ob.input();

        System.out.println("Array before sorting");
        ob.display();

        long startTime = System.nanoTime();

        ob.sort();

        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000000.0;

        System.out.println("Array after sorting");
        ob.display();

        System.out.println("Time for sorting = " + duration + " ms");
    }
}
