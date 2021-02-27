package Boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1260_DFS와BFS {
	
	static int N, M, V;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 수 1~N
		M = sc.nextInt(); // 간선의 수
		V = sc.nextInt(); // 시작 정점
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];

		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = 1;
			map[to][from] = 1; // 무향 그래프
		}
		
		dfs(V);
		
		System.out.println();
		
		bfs(V);
		
	}
	
	static void dfs(int v) {
		System.out.print(v+" ");
		visit[v] = true;
		for(int n=1; n<=N; n++) {
			if(map[v][n]==1 && !visit[n]) {
				dfs(n);
			}
		}
	}
	
	static void bfs(int v) {
		
		visit = new boolean[N+1];
		queue = new LinkedList<>();
		queue.add(v);
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			
			int q = queue.poll();
			System.out.print(q+" ");
			
			for(int n=1; n<=N; n++) {
				if(map[q][n]==1 && !visit[n]) {
					visit[n] = true;
					queue.add(n);
				}
			}
			
		}
		
	}
	
}
