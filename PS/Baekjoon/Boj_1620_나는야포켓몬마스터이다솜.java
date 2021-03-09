package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620_나는야포켓몬마스터이다솜 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> poketmonMap = new HashMap<String, Integer>();
		String[] poketmon = new String[N+1]; 
		StringBuilder sb = new StringBuilder();
		
		for(int n=1; n<=N; n++) {
			String name = br.readLine();
			poketmonMap.put(name, n);
			poketmon[n] = name;
		}
		
		for(int m=1; m<=M; m++) {
			
			String p = br.readLine();
			
			boolean number = checkNumber(p);
			
			if(number) {
				sb.append(poketmon[Integer.parseInt(p)]);
			}else {
				sb.append(poketmonMap.get(p));
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

	private static boolean checkNumber(String p) {
		
		if(p.equals("")) return false;
		
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) < 48 || p.charAt(i) > 58) return false;
		}
		
		return true;
	}
	
}
