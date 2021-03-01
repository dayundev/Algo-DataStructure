package Boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1463_1로만들기_BFS {
	
	
	static int ans;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		bfs(N);
		
		System.out.println(ans);
		
	}
	
	static void bfs(int n){

		queue = new LinkedList<>();
		queue.add(n);
		
		while(!queue.isEmpty()) {
			
			int qSize = queue.size();
			for(int s=0; s<qSize; s++) {
				int p = queue.poll();
				if(p == 1) return;
				if(p%3 == 0) queue.add(p/3);
				if(p%2 == 0) queue.add(p/2);
				queue.add(p-1);
			}
			ans++;
			
		}	
		
	}
	
}
