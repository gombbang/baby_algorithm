// n -> k진수
// 소수가 몇개인지?
// 소수 자체에 0이 들어있는 소수는 제외한다.
// 소수의 0 외에는 주변에 아무것도 없어야 함
// 진수는 3보다 크고 10보다 작음
// 이뤄질 수 있는 수가 1 ~ 9라는 소리
// 각 진수에 따라 고려해야 할 소수가 정해짐
// 0으로 감싸진 수를 다 컨버팅
// 각 값을 소수인지 일일이 계산하면서 체크해보자.
// 1과 자기 자신 외에 나눠지는 게 없는 수가 소수
import java.util.*;

class Solution {
    
    private String convertToK(int n, int k) {
        String ret = "";
        // 진수 바꾸는 법
        // n을 k로 나눴을 때 남은 몫을 맨 앞자리로, 없으면 0으로
        // 그 다음에 나눠서 몫 ㄱㄱㄱㄱ
        // 맨 마지막에 값이 k보다 작으면 그 값이 마지막 수
        
        int cur = 0;
        
        while (n > k) {
            cur = n % k;
            n = n - cur;
            n = n / k;
            
            ret += cur;
        }
        ret += n;
//         ret == reversed value
        StringBuffer sb = new StringBuffer(ret);
        ret = sb.reverse().toString();
        return ret;
    }
    
    private String[] kNumberToNumbers(String str) {
        return str.split("0");
    }
    
    private int kNumbersToFindAnswer(String[] strs) {
        int ans = 0;
        boolean flag = false;
        for (String str : strs) {
            if (str.equals(""))     // 에러 핵심 포인트, split쓸 때 꼭 remind 할 것
                continue;
            Double target = Double.valueOf(str);
            long t = (long)Math.ceil(target);
            if (target == 1.0)
                continue;
            if (target > 10000)
                t = (long)Math.ceil(Math.sqrt(target));
            for (int i = 2; i<t; i++) {
                if (target%i == 0) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag)
                ans ++;
            flag = false;
        }
        return ans;
    }
    
    public int solution(int n, int k) {
        int answer = -1;
        
        String kNumber = convertToK(n,k);
        String[] kNumbers = kNumberToNumbers(kNumber);
        answer = kNumbersToFindAnswer(kNumbers);
        
        
        return answer;
    }
}
