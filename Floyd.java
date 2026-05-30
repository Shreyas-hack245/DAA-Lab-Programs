import java.util.Scanner;

public class Floyd
{
    static int[][] dist;
    static int n;
    static final int INF = 999;

    static void compute_floyd()
    {
        int i, j, k;

        for(k = 1; k <= n; k++)
        {
            for(i = 1; i <= n; i++)
            {
                for(j = 1; j <= n; j++)
                {
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }

            System.out.println("Distance matrix iteration: " + k);

            for(i = 1; i <= n; i++)
            {
                for(j = 1; j <= n; j++)
                {
                    if(dist[i][j] == INF)
                        System.out.print("INF\t");
                    else
                        System.out.print(dist[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        int i, j;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        n = sc.nextInt();

        dist = new int[n + 1][n + 1];

        System.out.println("Enter the weighted matrix (99 for no edge):");

        for(i = 1; i <= n; i++)
        {
            for(j = 1; j <= n; j++)
            {
                int val = sc.nextInt();

                if(val == 99)
                    dist[i][j] = INF;
                else
                    dist[i][j] = val;
            }
        }

        compute_floyd();

        System.out.println("Final shortest path matrix:");

        for(i = 1; i <= n; i++)
        {
            for(j = 1; j <= n; j++)
            {
                if(dist[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
