package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11399_ATM {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(p);
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			ans += (p[i]*(N-i));
		}
		System.out.println(ans);
		
	}
	
}
