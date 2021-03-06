package Boj;

import java.util.Scanner;

public class Boj_1003_피보나치함수 {
	
	static int[][] D;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		D = new int[42][2];
		// D[n][0] : n이 가진 0의 개수 , D[n][1] : n이 가진 1의 개수 
		D[0][0] = 1;
		D[1][1] = 1;
		D[2][0] = 1; D[2][1] = 1;
		for(int tc=1; tc<=TC; tc++) {
			int n = sc.nextInt();
			fibo(n);
			System.out.println(D[n][0]+" "+D[n][1]);
		}
		
	}

	private static void fibo(int n) {
		if(n == 0 || n == 1) return;
		if(D[n][0] == 0 && D[n][1] == 0) {
			fibo(n-1);
		}
		D[n+1][0] = D[n][0] + D[n-1][0];
		D[n+1][1] = D[n][1] + D[n-1][1];
	}
	
}
