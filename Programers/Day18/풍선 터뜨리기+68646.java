
// + 7
import java.util.*;


class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int minLeft = a[0];
        int maxLeft = a[0];
        
        int[] minRight = new int[a.length];
        minRight[minRight.length-1] = a[minRight.length-1];
        for (int i = a.length-2; i>1; i--) {
            if (minRight[i+1] > a[i])
                minRight[i] = a[i];
            else
                minRight[i] = minRight[i+1];
        }
        
        for (int i = 1; i < a.length-1; i++) {
            // 왼쪽이 다 나보다 크다.
            if (minLeft > a[i]) {
                minLeft = a[i];
                answer ++;
            } else { // 왼쪽이 나보다 작은 값이 존재한다.
                if(maxLeft < a[i]) {// 왼쪽 비교 시 내가 제일 크다.
                    maxLeft = a[i];
                    continue;
                }
                else { // 왼쪽에 하나라도 자기보다 큰 값이 있다.
                    // 오른쪽에 자기보다 큰값들만 있으면 된다.
                    if (minRight[i+1] > a[i])
                        answer++;
                }
            }
        }
        
        return answer;
    }
}
// 시간초과에 대한 생각이 필요할 것 같다.
// 그러면 이 문제를 O(?)까지는 처리해야한다라는 기준이 생길 것

// 인접한 두 풍선 중에서 번호가 더 작은 풍선을 터트리는 행위는 최대 1번만 할 수 있습니다.
// 어떤 시점에서 인접한 두 풍선 중 번호가 더 작은 풍선을 터트렸다면, 그 이후에는 인접한 두 풍선을 고른 뒤 번호가 더 큰 풍선만을 터트릴 수 있습니다.

// 인접 이므로 앞 뒤 순서가 중요
// 번호가 작은건 한번만 터트림, 그 외에는 큰 것만
// 안 되는 경우만 생각해보자면
// 앞 뒤로 다 처리했을 때, 앞 뒤 중에 자기보다 숫자가 작은게 하나 초과한다
// 앞 부분에서 가장 작은 숫자가 자기보다 작고
// 뒷 부분에서 가장 작은 숫자가 자기보다 작으면
// 불가능

// 맨앞과 맨 뒤는 반드시 가능함
// 중간에서는 앞 부분과 뒷부분을 잘라서 MIN을 찾고, 그 MIN이 자기보다 작은 횟수가 1이 아니면 불가능으로 본다.

// 한 쪽에 자기보다 큰 값만 있고, 한쪽에는 자기보다 큰 값이 하나라도 있고 하면 된다.
// https://moonsbeen.tistory.com/180
// 시간 초과가 있을 때에는 메모리를 엄청 쓰면 된다.
// 반복문을 돌면서 찾기 대신 오른쪽에서의 최솟값을 반대에서부터 찾아서 
// 매번 배열값에 넣어뒀다...
