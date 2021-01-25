package demo.grap;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class Grap {
    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    public Grap(String fileName) {
        File file = new File("g.txt");
        try (Scanner scanner = new Scanner(file)) {
            this.V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            this.adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                this.adj[i] = new TreeSet<>();
            }
            this.E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                validateVertex(a);
                validateVertex(b);
                // 简单图
                // 自环边
                if (a == b) throw new IllegalArgumentException("Self loop is Detected");
                // 不是平行边
                if (this.adj[a].contains(b)) throw new IllegalArgumentException("Parallel Edges are Detected");
                this.adj[a].add(b);
                this.adj[b].add(a);
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
        return adj[v].contains(w);
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
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
        for (int v = 0; v < V; v++) {
            res.append(String.format("%d : ",v));
            for (int w: adj[v]) {
                res.append(String.format("%d ",w));
            }

            res.append("\n");

        }
        return res.toString();
    }

    public static void main(String[] args) {
        Grap adjMatrix = new Grap("g.txt");
        System.out.println(adjMatrix);
    }
}
