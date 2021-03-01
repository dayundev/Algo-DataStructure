package Boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1012_유기농배추_BFS {
	
	static int M, N, K;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Point> queue;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			
			M = sc.nextInt(); // 열
			N = sc.nextInt(); // 행
			K = sc.nextInt();
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for(int k=0; k<K; k++) {
				int j = sc.nextInt();
				int i = sc.nextInt();
				map[i][j] = 1;
			}
			
			queue = new LinkedList<>();
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						++count;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
	}

	private static void bfs(int i, int j) {
		
		queue.add(new Point(i, j));
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point x = queue.poll();
			for(int d=0; d<4; d++) {
				int ni = x.i + di[d];
				int nj = x.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
				if(map[ni][nj] == 1 && !visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
			}
		}
		
	}
	
}
