package Boj;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 우선순위 큐 : FIFO 순서가 아니라 우선순위가 높은 순서대로 먼저 나가게 됨
 * Java int의 범위 : -2^31 ~ 2^31
 * */

public class Boj_1927_최소힙 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = sc.nextInt();
		for(int n=0; n<N; n++) {
			
			int x = sc.nextInt();
			
			if(x == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(x);
			}
			
		}
		
	}
	
}
