package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_1074_Z {
	
	static int N, r, c, ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		solve(r, c, (int)Math.pow(2, N), 0);
		
		System.out.println(ans);
		
	}

	private static void solve(int sr, int sc, int n, int cnt) {
		
		if(n == 2) {
			if(sr==0 && sc==0) ans = cnt;
			if(sr==0 && sc==1) ans = cnt+1;
			if(sr==1 && sc==0) ans = cnt+2;
			if(sr==1 && sc==1) ans = cnt+3;
			return;
		}
		
		if(0<=sr && sr<n/2 && 0<=sc && sc<n/2) {
			solve(sr, sc, n/2, cnt);
		}
		if(0<=sr && sr<n/2 && n/2<=sc && sc<n) {
			solve(sr, sc-n/2, n/2, cnt + (int)Math.pow(n/2, 2));
		}
		if(n/2<=sr && sr<n && 0<=sc && sc<n/2) {
			solve(sr-n/2, sc, n/2, cnt + (int)Math.pow(n/2, 2)*2);
		}
		if(n/2<=sr && sr<n && n/2<=sc && sc<n) {
			solve(sr-n/2, sc-n/2, n/2, cnt + (int)Math.pow(n/2, 2)*3);
		}
		
	}
	
}
