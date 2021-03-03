package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1389_케빈베이컨의6단계법칙_BFS {
	
	static int N, M, pAns, kAns;
	static int[][] relationship;
	static boolean[] visit;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		relationship = new int[N+1][N+1];
		pAns = Integer.MAX_VALUE;
		kAns = Integer.MAX_VALUE;
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			relationship[start][from] = 1;
			relationship[from][start] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			
			visit = new boolean[N+1];
			queue = new LinkedList<>();
			queue.add(i);
			
			int kNum = 0; // 케빈 베이컨 수
			int dist = 0;
			while(!queue.isEmpty()) {
				
				int qSize = queue.size();
				
				int cnt = 0; 
				for(int s=0; s<qSize; s++) {
					int start = queue.poll();
					for(int j=1; j<=N; j++) {
						if(relationship[start][j] == 1 && !visit[j]) {
							++cnt;
							visit[j] = true;
							queue.add(j);
						}
					}
				}
				
				kNum += cnt * ++dist;
			}
			
			if(kNum == kAns) {
				pAns = Math.min(pAns, i);
			}else if(kNum < kAns) {
				kAns = kNum;
				pAns = i;
			}
			
		}
		
		System.out.println(pAns);
		
		
	}
	
}
