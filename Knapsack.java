import java.util.Scanner;

public class Knapsack {
    static int[] p, wt;      
    static int c, n;         

    static void knap() {
        int[][] k = new int[n + 1][c + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= c; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (wt[i] <= w) {
                    k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }

        // Print selected items
        System.out.println("\n SELECTED ITEMS ");
        int rc = c;  // Fixed: renamed to avoid shadowing
        int m = n;
        
        while (m > 0 && rc > 0) {
            if (k[m][rc] != k[m - 1][rc]) {
                System.out.println("Item " + m + " | Weight: " + wt[m] + " | Profit: " + p[m]);
                rc = rc - wt[m];
            }
            m--;
        }
        
        System.out.println("\nTotal Profit: " + k[n][c]);
        
        System.out.println("\nintermediat results capacity:\t");
        System.out.print("Capacity\t");
        for (int j = 0; j <= c; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();
        
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("Item 0(0,0)\t");
            } else {
                System.out.print("Item " + i + "(" + p[i] + "," + wt[i] + ")\t");
            }
            for (int j = 0; j <= c; j++) {
                System.out.print(k[i][j] + "\t");
            }
            System.out.println();
        }
    }


    static int max(int a, int b) {
        return (a > b ? a : b);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        

        System.out.print("Enter number of items: ");
        n = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        c = sc.nextInt();
        

        wt = new int[n + 1];
        p = new int[n + 1];
        

        System.out.println("\nEnter weight and profit for each item:");
        for (int i = 1; i <= n; i++) {
            System.out.print("Item " + i + " -> Weight: ");
            wt[i] = sc.nextInt();
            System.out.print("         Profit: ");
            p[i] = sc.nextInt();
        }
        
        System.out.println("Number of Items: " + n);
        System.out.println("Knapsack Capacity: " + c);
        System.out.println("\nItems Details:");
        for (int i = 1; i <= n; i++) {
            System.out.println("Item " + i + " -> Weight: " + wt[i] + ", Profit: " + p[i]);
        }
        

        knap();
        
        sc.close();
    }
}