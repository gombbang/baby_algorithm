import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        Map<Integer,Integer> t = new HashMap<>();
        for (int i : tangerine) {
            if (t.get(i) == null)
                t.put(i,1);
            else 
                t.put(i,t.get(i)+1);
        }
        
        List<Integer> valueList = new ArrayList<>(t.values());
        valueList.sort(Integer::compareTo);
        int compare = 0;
        int answer = 0;
        for (int i = valueList.size()-1; i>= 0; i--) {
            compare += valueList.get(i);
            answer ++;
            if (compare >= k)
                break;
        }
        return answer;
    }
}
