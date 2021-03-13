# :green_apple: 완전탐색의 기초 : 순열, 조합, 부분집합
## :one: 순열
### 1) **순열이란?**
 + 서로 다른 것들 중 몇 개를 뽑아서 한 줄로 나열하는 것
 + **순서가 유의미**
 + nPr : 서로 다른 n개 중 r개를 택하는 순열의 경우의 수
 + nPr = n * (n-1) * (n-2) * ... * (n-r+1)
 + nPn = n! <br />
 ![h](https://t1.daumcdn.net/cfile/tistory/2478E333534BD6BB35)
 + 순열 nPn에서 n>12인 경우, 시간복잡도는 폭발적으로 증가한다 => 마지노선 10!
### 2) **순열 알고리즘 만들기 - 재귀**
 + **코드**
   1. numbers[] : 순열 저장 배열
   2. isSelected[] : 인덱스에 저장된 숫자가 사용 중인지 아닌지를 저장하는 배열
   3. cnt : 현재까지 뽑은 순열 수의 개수
        ```java
        perm(int cnt) { // cnt: 현재까지 뽑은 자릿수
            
            // 숫자 세개를 다 뽑으면 출력 (0,1,2번째)
            if(cnt == 3){
                for(int i=0; i<3; i++){
                  System.out.print(numbers[i]+" ");
                }
                System.out.println();
            } else {
                for(int i=1; i<=3; i++){ // 1~3 중에서 !!!
                  if(isSelected[i] == true) continue; // 이미 사용중인 숫자라면, 순열에 저장하지 않는다.
                  numbers[cnt] = i; // 순열에 저장한다.
                  isSelected[i] = true; // 사용 중임을 표시
                  perm(cnt+1); // 다음자리수를 뽑으러 간다.	
                  isSelected[i] = false; // 돌아오는 길에 사용 표시를 풀어준다.
            } 
            
        }  
        ```
 + **그림 그려보기** <br /> 
   ![image](https://user-images.githubusercontent.com/78152629/111036915-13949500-8465-11eb-85d3-40d476e35126.png)

## :two: 조합
### 1) **조합이란?**
 + 서로 다른 n개의 원소 중 r개를 순서에 상관없이 골라낸 것
 + **순서가 무의미**
 + nCr = n! / (n-r)! r!
 + nPr = n! / (n-r)! 에서 순서는 다르지만 같은 숫자를 가진 경우는 없애준다 x (1/r!) = nCr
### 2) **조합 알고리즘 만들기 - 재귀** <br />
 + **조합 알고리즘 생각해보기** 😎 <br /> 
 ![image](https://user-images.githubusercontent.com/78152629/111037351-fcef3d80-8466-11eb-8560-c82212c38815.png) <br /> 
  => 앞서 뽑았던 숫자의 인덱스보다 큰 인덱스부터 뽑으면 된다.
 + **코드**
   1. input[] : n개의 원소를 가지고 있는 배열
   2. numbers[] : r개의 크기 배열, 조합이 저장될 배열 
   3. cnt : 현재까지 뽑은 조합 원소 개수
   4. start : 조합에 시도할 원소의 시작 인덱스
        ```java
        comb(int cnt, int start) {
            if(cnt == r){
              // 조합 생성 완료
              return;	}
            else{
              for(int i=start; i<N; i++){ // start부터 시작한다.
                numbers[cnt] = input[i];
                comb(cnt+1, i+1);
              }
            }
        } 
        ```
## :three: 부분집합
### 1) **부분집합이란?**
 + 집합에 포함된 원소들을 선택하는 것
 + 어떠한 문제에서 내가 원소들을 선택하는 경우에 그 **선택의 개수가 가변적**인 것
 + 부분집합의 개수 : 집합의 원소가 n개일 때, **공집합을 포함**한 부분집합 수는 2의 n승
 + 부분집합은 조합을 반복문으로 돌리는 방법을 통해 구할 수 있다. -> R을 N번 돌리면 가능
### 2) **부분집합 알고리즘 생성 - 재귀**
 + 각 원소를 부분집합에 **포함/비포함**의 형태로 재귀적 구현
 + **코드**
   ```java
   subset(int cnt){
       if(cnt == N){
           // 부분집합 완성
           return;
       }else {
           isSelected[cnt] = true; // 포함
           subset(cnt+1);
           isSelected[cnt] = false; // 
           subset(cnt+1);
       }
   }
   ```
  + **그림 그려보기** <br />
    ![image](https://user-images.githubusercontent.com/78152629/111037892-79831b80-8469-11eb-9c97-72106008199b.png)
