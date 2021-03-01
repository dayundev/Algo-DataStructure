package Boj;

import java.util.Scanner;

public class Boj_1012_유기농배추_DFS {
	
	static int M, N, K;
	static int[][] map;
	static boolean[][] visit;
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
			
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						++count;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
	}

	private static void dfs(int i, int j) {
		
		visit[i][j] = true;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
			if(map[ni][nj] == 1 && !visit[ni][nj]) {
				dfs(ni, nj);
			}
		}
		
	}
	
}
