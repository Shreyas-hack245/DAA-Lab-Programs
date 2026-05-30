import java.util.*;

public class SumOfSubset {
    static int[] set, x;
    static int d, n;

    static void sumofsub(int s, int k) {
        x[k] = 1;

        if (s + set[k] == d) {
            System.out.print("{ ");
            for (int i = 1; i <= n; i++)
                if (x[i] == 1)
                    System.out.print(set[i] + " ");
            System.out.println("}");
        } else {
            if (s + set[k] < d && k + 1 <= n)
                sumofsub(s + set[k], k + 1);

            if (k + 1 <= n && s + set[k + 1] <= d) {
                x[k] = 0;
                sumofsub(s, k + 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        System.out.println("Enter size of set:");
        n = sc.nextInt();

        set = new int[n + 1];
        x = new int[n + 1];

        System.out.println("Enter set elements:");
        for (int i = 1; i <= n; i++) {
            set[i] = sc.nextInt();
            sum += set[i];
        }

        System.out.println("Enter required sum:");
        d = sc.nextInt();

        if (sum < d)
            System.out.println("No subset possible");
        else
            sumofsub(0, 1);
    }
}
