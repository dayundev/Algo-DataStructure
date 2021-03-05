package Boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1463_1로만들기_ver1 {
	
	static class Point{
		int x, count;
		Point(int x, int count){
			this.x = x;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[] visit = new boolean[10000001];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0));
		
		int ans = 0;
		int num = 0;
		while(!queue.isEmpty()) {
			
			Point p = queue.poll();
			
			if(p.x%3 == 0 && 0<=p.x/3 && p.x/3<=10000000 && !visit[p.x/3]) {
				visit[p.x/3] = true;
				num = p.x/3;
				queue.add(new Point(num, p.count+1));
			}
			if(num == 1) {
				ans = p.count + 1;
				break;
			}
			
			if(p.x%2 == 0 && 0<=p.x/2 && p.x/2<=10000000 && !visit[p.x/2]) {
				visit[p.x/2] = true;
				num = p.x/2;
				queue.add(new Point(num, p.count+1));
			}
			if(num == 1) {
				ans = p.count + 1;
				break;
			}
			
			if(0<=p.x-1 && p.x-1<=10000000 && !visit[p.x-1]) {
				visit[p.x-1] = true;
				queue.add(new Point(p.x-1, p.count+1));
			}
			
			if(p.x-1 == 1) {
				ans = p.count + 1;
				break;
			}
			
		}
		
		System.out.println(ans);
		
	}
	
}
