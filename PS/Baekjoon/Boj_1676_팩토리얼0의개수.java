package Boj;

import java.util.Scanner;

public class Boj_1676_팩토리얼0의개수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0; 
		
		while(true) {
			
			if(N < 5) break;
			cnt += N/5;
			N /= 5;
			
		}
		
		System.out.println(cnt);
		
	}
	
}
