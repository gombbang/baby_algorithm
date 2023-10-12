// 최소 단계
// 각 단어에 최소로 오는 횟수를 찾아낸다
// 만약 최소 횟수를 넘어서면 패스
// 
import java.util.*;

class Solution {
//     public int solution(String begin, String target, String[] words) {
//         int answer = 0;
//         boolean checkTarget = false;
//         Stack<String> stack = new Stack<>();
//         Map<String,Integer> map = new HashMap<>();
        
//         for (int i = 0 ; i<words.length; i++) {
//             if (words[i].equals(target)) {
//                 checkTarget = true;
//             } else {
//                 if ((findDiffOne(begin,words[i]))) {
//                     stack.add(words[i]);
//                     map.put(words[i],1);
//                 }
//             }
//         }
//         if (!checkTarget)
//             return 0;
        
//         while(!stack.isEmpty()) {
//             String word = stack.pop();
//             int count = map.get(word);
//             for (int i = 0; i<words.length; i++) {
                
//                 if (findDiffOne(word,words[i])) {
                    
//                     if (map.get(words[i]) != null) {
//                         if (map.get(words[i]) >= count +1) {
//                             if (!target.equals(words[i]))
//                                 stack.add(words[i]);
//                             map.put(words[i],count+1);
//                         }
//                     } else {
//                         if (!target.equals(words[i]))
//                             stack.add(words[i]);
//                         map.put(words[i],count+1);
//                     }
//                 }
//             }
//         }
        
//         if(map.get(target) == null)
//             return 0;
//         else 
//             return map.get(target);
//     }
    
    private boolean findDiffOne(String str1, String str2) {
        int diff = 0;
        for (int j = 0; j<str1.length(); j++) {
            if (str1.charAt(j) != str2.charAt(j))
                diff++;
            if (diff > 1)
                break;
        }
        
        return diff == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean checkTarget = false;
        Stack<String> stack = new Stack<>();
        
        for (int i = 0 ; i<words.length; i++) {
            if (words[i].equals(target)) {
                checkTarget = true;
                break;
            }
        }
        if (!checkTarget)
            return 0;
        boolean[] visited = new boolean[words.length];
        answer = dfs(begin, target, words, visited, 1 , Integer.MAX_VALUE);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
        
    }
    
    private int dfs(String begin, String target, String[] words, boolean[] visited, int count, int answer) {
       if (begin.equals(target)) {
            return count - 1;
        }
        for (int i = 0; i<words.length; i++) {
            if(!visited[i] && findDiffOne(begin,words[i])) {
                visited[i] = true;
                answer = Math.min(answer, dfs(words[i], target, words, visited, count+1, answer));
                visited[i] = false;
            }
        }
        return answer;
    }
}
