import java.util.*;

public class BinarySearch {
    static int bin(int arr[], int n, int key) {
        int low = 0, high = n - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int key, n, pos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the sorted array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter the key:");
        key = sc.nextInt();

        pos = bin(arr, n, key);

        if (pos > -1)
            System.out.println("Element found at position " + pos);
        else
            System.out.println("Element not found");
    }
}
