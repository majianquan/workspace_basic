package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	// 存储顶点的结合
	private ArrayList<String> vertexList;
	// 存储图对应的领结矩阵
	private int[][] edges;
	// 表示边的个数
	private int numOfEdges;
	// 记录某个结点是否被访问过
	private boolean[] isVisited ;

	public static void main(String[] args) {
		int n = 5;
		String[] Vertexs = {"A","B","C","D","E"};

		Graph graph = new Graph(n);
		for (String vertex: Vertexs) {
			graph.insertVertex(vertex);
		}
		graph.insertEdge(0,1,1);
		graph.insertEdge(0,2,1);
		graph.insertEdge(1,2,1);
		graph.insertEdge(1,3,1);
		graph.insertEdge(1,4,1);

		graph.showGraph();
		// graph.dfs();
		graph.bfs();
	}


	public Graph(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<>(n);
		numOfEdges = 0;
		isVisited = new boolean[n];
	}

	// 插入顶点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * 添加边
	 * @param v1 表示点的下标
	 * @param v2 表示点的下标
	 * @param weight 权值
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

	/**
	 *  返回顶点的个数
	 * @return
	 */
	public int getNumofVertex() {
		return vertexList.size();
	}

	/**
	 * 返回边的个数
	 * @return
	 */
	public int getNumOfEdges(){
		return numOfEdges;
	}

	/**
	 * 返回结点i对应的数据
	 * @param i
	 * @return
	 */
	public String getValueByIndex(int i) {
		return  vertexList.get(i);
	}

	/**
	 * 返回v1,v2的权值
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	//显示图对应的矩阵
	public void showGraph(){
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	// 得到第一个邻接节点的下标w
	public int getFirstNeighbor(int index) {
		for (int i = 0; i < vertexList.size(); i++) {
			if(edges[index][i] > 0) {
				return i;
			}
		}
		return -1;
	}
	// 根据前一个邻接节点的下标获取下一个邻接节点的下标
	public int getNextNeighbor(int v1,int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if(edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	// 对一个节点深度优先遍历
	private void dfs(boolean[] isVisited,int i) {
		// 首先访问该节点
		System.out.print(getValueByIndex(i) + "->");
		// 将该结点设置为已访问
		isVisited[i] = true;
		// 查找结点i的第一个邻接节点
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if(!isVisited[w]) {
				dfs(isVisited,w);
			}
			w = getNextNeighbor(i,w);
		}

	}
	// 深度优先遍历
	public void dfs(){
		for (int i = 0; i < getNumofVertex(); i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}
	// 对一个节点进行广度优遍历
	private void bfs(boolean[] isVisited,int i) {
		int u; // 表示队列的头节点对应的下标
		int w; // 邻接节点w
		// 队列,记录结点访问的顺序
		LinkedList queue = new LinkedList();
		System.out.print(getValueByIndex(i) + "=>");
		isVisited[i] = true;
		queue.addLast(i);
		while (!queue.isEmpty()) {
			u = (Integer) queue.removeFirst();
			// 得到第一个邻接节点的下标w
			w = getFirstNeighbor(u);
			while (w != -1) {
				if(!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "=>");
					isVisited[w] = true;
					// 入队
					queue.addLast(w);
				}
				w = getNextNeighbor(u,w);
			}
		}
	}
	// 广度优先遍历
	public void bfs(){
		for (int i = 0; i < getNumofVertex(); i++) {
			if(!isVisited[i]){
				bfs(isVisited,i);
			}
		}
	}
}
