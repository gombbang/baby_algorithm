// 모르는게 오히려 더 굉장했다, 2배 더 성능 좋음.
import java.util.*;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i <prices.length; i++) {
            for (int j = i+1 ; j<prices.length; j++) {
                answer[i] ++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        
        return answer;
    }
}
// 코자타임이 옵니다.
