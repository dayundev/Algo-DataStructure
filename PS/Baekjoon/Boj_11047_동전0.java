package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11047_동전0 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] val = new int[N];
		for(int i=0; i<N; i++) {
			val[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0; // 동전 개수의 최솟값
		for(int i=N-1; i>=0; i--) {
			if(K >= val[i]) {
				cnt += (K/val[i]);
				K = (K%val[i]);
			}
		}
		System.out.println(cnt);
		
	}
	
}
