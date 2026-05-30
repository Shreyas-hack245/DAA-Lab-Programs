import java.util.*;

public class kruskalMST
{
    static int[][] wt;
    static int n, mincost, v1 = 0, v2 = 0;

    static void kruskal()
    {
        int i, edgewt;
        int[] root = new int[n + 1];

        for(i = 1; i <= n; i++)
        {
            root[i] = i;
        }

        System.out.println("Edges of min-cost spanning tree are");

        i = 0;

        while(i != n - 1)
        {
            find();

            edgewt = wt[v1][v2];
            wt[v1][v2] = wt[v2][v1] = 0;

            if(root[v1] != root[v2])
            {
                System.out.println("(" + v1 + "," + v2 + ")");
                union(root, v1, v2);
                mincost += edgewt;
                i++;
            }
        }

        System.out.println("Cost of min-cost spanning tree = " + mincost);
    }

    static void find()
    {
        int edgewt = 99, i, j;

        for(i = 1; i <= n; i++)
        {
            for(j = i + 1; j <= n; j++)
            {
                if(wt[i][j] > 0 && wt[i][j] < edgewt)
                {
                    edgewt = wt[i][j];
                    v1 = i;
                    v2 = j;
                }
            }
        }
    }

    static void union(int root[], int v1, int v2)
    {
        int temp, i;

        temp = root[v2];

        for(i = 1; i <= n; i++)
        {
            if(root[i] == temp)
            {
                root[i] = root[v1];
            }
        }
    }

    public static void main(String[] args)
    {
        int i, j;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        n = sc.nextInt();

        wt = new int[n + 1][n + 1];

        System.out.println("Enter the undirected graph as weighted matrix");

        for(i = 1; i <= n; i++)
        {
            for(j = 1; j <= n; j++)
            {
                wt[i][j] = sc.nextInt();
            }
        }

        kruskal();
    }
}
