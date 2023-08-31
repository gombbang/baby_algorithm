import java.util.*;

class Solution {
    List<boolean[]> ops = new ArrayList<>();
    
    private void makeOps(int length, String op, int now) {
        if (length == now) {
            boolean[] oper= new boolean[length];
            char[] opc = op.toCharArray();
            int index = 0;
            for (char c : opc) {
                if (c == '1')
                    oper[index] = true;
                index++;
            }
            ops.add(oper);
            return;
        } 
        makeOps(length, op+1, now+1);
        makeOps(length, op+0, now+1);
    }
    
    private int calculate (int[] numbers, boolean[] op) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (op[i])
                result += numbers[i];
            else
                result -= numbers[i];
        } 
        return result;
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // 매번 조합 ㄱㄱ
        makeOps(numbers.length, "", 0);
        for (boolean[] op :ops) {
            if (calculate(numbers, op) == target)
                answer ++;
        }
        return answer;
    }
}
// https://codechacha.com/ko/java-sort-map/
