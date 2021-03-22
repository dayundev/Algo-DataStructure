package Boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_7569_토마토 {
	
	static int N, M, H, day;
	static int[][][] box;
	static Queue<Point> queue;
	
	static class Point{
		int i, j, h;
		Point(int i, int j, int h){
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}
	
	static int[] di = {0,0,-1,1,0,0};
	static int[] dj = {1,-1,0,0,0,0};
	static int[] dh = {0,0,0,0,-1,1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		
		box = new int[N][M][H];
		queue = new LinkedList<>();
		day = 0;
		
		boolean done = true;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					box[i][j][h] = sc.nextInt();
					if(box[i][j][h] == 0) done = false;
					if(box[i][j][h] == 1) queue.add(new Point(i, j, h));
				}
			}
		}
		
		if(done) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		done = true;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[i][j][h] == 0) done = false;
				}
			}
		}
		
		if(!done) day = -1;
		System.out.println(day == -1 ? -1 : day-1);
		
	}

	private static void bfs() {
		
		while(!queue.isEmpty()) {

			int qSize = queue.size();
			for(int s=0; s<qSize; s++) {
				
				Point n = queue.poll();
				
				for(int d=0; d<6; d++) {
					int ni = n.i + di[d];
					int nj = n.j + dj[d];
					int nh = n.h + dh[d];
					if(ni<0 || ni>=N || nj<0 || nj>=M || nh<0 || nh>=H) continue;
					if(box[ni][nj][nh] == 0) {
						queue.add(new Point(ni, nj, nh));
						box[ni][nj][nh] = 1;
					}
				}
				
			}
			day++;
			
		}
		
	}
	
}
