package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 그리디 : 최소 값을 찾기 위해 먼저 +연산을 모두 진행한 후, -연산을 진행.
 * 1. 입력으로 주어진 식을 -를 기준으로 모두 나눠준다.
 * 2. 나눠진 연산들은 모두 +연산으로 이루어져있으므로 먼저 계산을 진행한다.
 * 3. +로 계산된 값들은 리스트에 저장하고, 
 * 4. 이후 모든 +계산이 끝났다면 리스트에 있는 값들을 모두 -연산으로 계산한다.
 * */


public class Boj_1541_잃어버린괄호 {
	
	public static void main(String[] args) throws IOException {
	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    ArrayList<Integer> arr = new ArrayList<>(); // + 계산된 값들이 담길 리스트
		String[] temp1 = br.readLine().split("-");
		
		for(int i=0; i<temp1.length; i++) {
			
			String[] temp2 = temp1[i].split("\\+");
			
			int sum = 0;
			for(int j=0; j<temp2.length; j++) {
				sum += Integer.parseInt(temp2[j]);
			}
			arr.add(sum);
			
		}
		
		int ans = 0;
		for(int i=0; i<arr.size(); i++) {
			if(i == 0) { // 처음 들어온 연산은 그냥 넣어주기
				ans = arr.get(i);
				continue;
			}
			ans -= arr.get(i);
		}
		System.out.println(ans);
		
	}
	
}
