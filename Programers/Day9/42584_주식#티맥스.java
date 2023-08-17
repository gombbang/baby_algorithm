import java.util.*;

class Solution {
    // 큐로 데이터 다 가져옴
    // 만약 값이 시간초를 세지 않아야할 때에는 불값으로 true 처리
    
    private boolean[] disable;
    
    private class Pair{
        int index;
        int data;
        
        Pair(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }
    
    public int[] solution(int[] prices) {
        disable = new boolean[prices.length];
        int[] answer = new int[prices.length];
        int[] data = new int[prices.length];
        int cursorData = -1;
        int index = -1;
        
        Queue<Integer> q = new LinkedList<>();
        Stack<Pair> stack = new Stack<>();
        for (int price : prices) {
            q.offer(price);
        }
        
        while(!q.isEmpty()) {
            cursorData = q.poll();
            index++;
            if (stack.isEmpty())
                stack.add(new Pair(index, cursorData));   // start with 0
            else {
                if (stack.peek().data <= cursorData) {
                    stack.add(new Pair(index, cursorData));
                }
                else {
                    while (! stack.isEmpty()) {
                        if (stack.peek().data > cursorData) {
                            Pair pair = stack.pop();
                            answer[pair.index] = index - pair.index;
                        } else 
                            break;
                    }
                    
                    stack.add(new Pair(index, cursorData));
                }
            }
            
            
            // data[index] = cursor;
            // for (int i = 0; i < index; i ++) {
            //     if (!disable[i]) {
            //         if (cursor < data[i]) {
            //             disable[i] = true;
            //             answer[i] = index-i;
            //         }
            //     }
            // }
        }
        // for (int i = 0; i < answer.length-1; i++) {
        //     if (answer[i] == 0)
        //         answer[i] = answer.length-1-i;
        // }
        while (! stack.isEmpty()) {
            Pair pair = stack.pop();
            answer[pair.index] = prices.length - pair.index - 1;
        }
        
        return answer;
    }
}
