import java.util.Scanner;

public class Warshall
{
    static int[][] dist;
    static int n;

    static void compute_warshall()
    {
        int i, j, k;

        for(k = 1; k <= n; k++)
        {
            for(i = 1; i <= n; i++)
            {
                for(j = 1; j <= n; j++)
                {
                    dist[i][j] = (dist[i][j] | (dist[i][k] & dist[k][j]));
                }
            }

            System.out.println("Distance matrix iteration: " + k);

            for(i = 1; i <= n; i++)
            {
                for(j = 1; j <= n; j++)
                {
                    System.out.print(dist[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int i, j;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        n = sc.nextInt();

        dist = new int[n + 1][n + 1];

        System.out.println("Enter the weighted matrix (0 for no edge)");

        for(i = 1; i <= n; i++)
        {
            for(j = 1; j <= n; j++)
            {
                dist[i][j] = sc.nextInt();
            }
        }

        compute_warshall();

        System.out.println("Final transitive closure matrix:");

        for(i = 1; i <= n; i++)
        {
            for(j = 1; j <= n; j++)
            {
                System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
