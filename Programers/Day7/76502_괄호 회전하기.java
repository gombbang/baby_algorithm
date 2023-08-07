import java.util.*;

class Solution {
    private Stack<Character> stack = new Stack<>();
    
    private Boolean dist(String s) {
        char[] cs = s.toCharArray();
        char test;
        for (char c : cs) { 
            if (c == '[' || c == '{' || c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else {
                    test = stack.pop();
                    if (c == ']') {
                        if (test != '[')
                            return false;
                    }
                    else if ( c == '}') {
                        if (test != '{')
                            return false;
                    }
                    else {
                        if (test != '(')
                            return false;
                    }
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else 
            return false;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        String s1;
        char c1;
        
        if (dist(s))
            answer++;
        
            s1 = s;
        for ( int i =0; i<s.length()-1; i++) {
            c1 = s1.charAt(0);
            s1 = s1.substring(1);
            s1 += c1; 
            // System.out.println("s1 : " + s1);
            
            if (dist(s1))
                answer++;
        }        
        
        return answer;
    }
}
