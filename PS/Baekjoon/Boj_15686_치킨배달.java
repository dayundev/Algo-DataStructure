package Boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_15686_치킨배달 {
	
	static int N, M, ans;
	static int[][] map;
	static ArrayList<Point> chickenHouse;
	static Point[] comb;
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		chickenHouse = new ArrayList<>();
		comb = new Point[M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) chickenHouse.add(new Point(i,j));
			}
		}
		
		combination(0,0);
		System.out.println(ans);
		
	}

	private static void combination(int cnt, int start) {
		
		if(cnt == M) {
			int cDist = getCityChickDist();
			ans = Math.min(cDist, ans);
			return;
		}
		
		for(int i=start; i<chickenHouse.size(); i++) {
			comb[cnt] = chickenHouse.get(i);
			combination(cnt+1, i+1);
		}
		
	}

	private static int getCityChickDist() {
		
		int cityChickDist = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					int cDist = Integer.MAX_VALUE;
					for(int c=0; c<comb.length; c++) {
						int d = Math.abs(comb[c].i - i) + Math.abs(comb[c].j - j);
						cDist = Math.min(d, cDist);
					}
					cityChickDist += cDist;
				}
			}
		}
		
		return cityChickDist;
	}
	
}
