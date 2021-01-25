package demo.grap;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String fileName) {
        File file = new File("g.txt");
        try (Scanner scanner = new Scanner(file)) {
            this.V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            this.E = scanner.nextInt();
            this.adj = new int[V][V];
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                validateVertex(a);
                validateVertex(b);
                // 简单图
                // 自环边
                if (a == b) throw new IllegalArgumentException("Self loop is Detected");
                // 不是平行边
                if (this.adj[a][b] == 1) throw new IllegalArgumentException("Parallel Edges are Detected");
                this.adj[a][b] = 1;
                this.adj[b][a] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void validateVertex(int v) {
        if (v < 0 && v >= V) {
            throw new IllegalArgumentException("vertex " + v + "is invalid");
        }
    }

    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    public ArrayList<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public int degree(int v) {
        return adj(v).size();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("V = %d, E = %d \n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                res.append(String.format("%d ", this.adj[i][j]));
            }
            res.append("\n");

        }
        return res.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }
}
