import java.util.ArrayList;
import java.util.List;

class Solution {
    
        private long firstStep (String expression) {

            char[] cArray = expression.toCharArray();
            Long first = (long)-1; // 0일수도 있잖어
            Long second = (long)-1;
            char operator = 't';
            String temp="";
            List<Long> numbers = new ArrayList<>();
            List<Character> operators = new ArrayList<>();
            char[] levels = new char[3];
            long[] answers = new long[6];
            long answer;
            long hehe;
            boolean flag = false;

            for (char c : cArray) {
                if (c > 45) 
                    temp+=c;
                else {
                    if (operator == 't') 
                        operator = c;
                    
                    if (first == (long)-1)
                        first = Long.parseLong(temp);
                    else
                        second = Long.parseLong(temp);
                    temp = "";

                    if (second != (long)-1) {
                        // System.out.print("first : " + first);
                        // System.out.print(", second : " + second);
                        // System.out.print(", operator : " + operator);
                        // System.out.println();
                        if (!flag) {
                            numbers.add(first);
                            flag = true;
                        }
                        numbers.add(second);
                        operators.add(operator);

                        first = second;
                        // second = (long)-1;
                    }
                    operator = c;
                }
            }
            
            // System.out.print("first : " + first);
            // System.out.print(", Long.parseLong(temp) : " + Long.parseLong(temp));
            // System.out.print(", operator : " + operator);
            // System.out.println();
            
            numbers.add(Long.parseLong(temp));
            operators.add(operator);
            
            //6가지 방법으로 level을 만들어낸다.
            
            // for (long number : numbers) {
            //     System.out.print(number + " ");
            // }
            //     System.out.println();
            
            
            levels[0] = '*';
            levels[1] = '+';
            levels[2] = '-';
            answer = calculate(new ArrayList<>(numbers),new ArrayList<>(operators),levels);
            levels[0] = '*';
            levels[1] = '-';
            levels[2] = '+';
            hehe = calculate(new ArrayList<>(numbers),new ArrayList<>(operators),levels);
            // System.out.println("hehe : " + hehe);
            answer = answer > hehe ? answer : hehe;
            levels[0] = '+';
            levels[1] = '-';
            levels[2] = '*';
            hehe = calculate(new ArrayList<>(numbers),new ArrayList<>(operators),levels);
            // System.out.println("hehe : " + hehe);
            answer = answer > hehe ? answer : hehe;
            levels[0] = '+';
            levels[1] = '*';
            levels[2] = '-';
            hehe = calculate(new ArrayList<>(numbers),new ArrayList<>(operators),levels);
            answer = answer > hehe ? answer : hehe;
            levels[0] = '-';
            levels[1] = '*';
            levels[2] = '+';
            hehe = calculate(new ArrayList<>(numbers),new ArrayList<>(operators),levels);
            // System.out.println("hehe : " + hehe);
            answer = answer > hehe ? answer : hehe;
            levels[0] = '-';
            levels[1] = '+';
            levels[2] = '*';
            hehe = calculate(new ArrayList<>(numbers),new ArrayList<>(operators),levels);
            answer = answer > hehe ? answer : hehe;
            
            return answer;

    }
    
    private long calculate (List<Long> numbers,List<Character> operators,char[] levels) {
        long first = 0;
        while (operators.size() > 0) {
            for (int i = 0; i<levels.length;i++) {
                if (operators.size() > 0) {
                    for (int j = 0; j < operators.size();j++) {
                        if (operators.get(j) == levels[i]) {
                            // System.out.println(numbers.get(j) + " "
                            //                    + operators.get(j) + " " + numbers.get(j+1));
                            first = cal(numbers.get(j),numbers.get(j+1),operators.get(j));
                            numbers.remove(j);
                            numbers.remove(j);
                            operators.remove(j);
                            numbers.add(j,first);
                            j--;
                        }
                    }
                }
            }
        }
        if (first < 0)
            first*=-1;
        return first;
    }
    
    private long cal (long a, long b, char operator) {
        if (operator == '+')
            return a+b;
        else if (operator == '-')
            return a-b;
        else 
            return a*b;
    }
    
    public long solution(String expression) {
        long answer = firstStep(expression);
        
        return answer;
    }
}
// 연산자의 우선순위를 정의할 때 같은 순위의 연산자는 없어야 한다.
// 절대값 가능, 가장 큰 숫자를 제출한 사람이 우승, 제출 숫자가 우승상금.
// 가장 큰 경우를 만들 수 있게 해주면 될 것.
// queue와 stack을 잘 써야하는 것 같았는데
// 마지막에는 완전 탐색
// 3!에 해당하는 로직
// 자료구조는 ?
// 
// 숫자가 아닌걸 만날 때까지 ㄱㄱ
// 숫자 아닌걸 만나면 일단 두개 킵
// 1. 우선순위를 정한다
// 2. 우선순위에 맞게 계산하면서 끝까지 간다.
// 3. 결과에 해당하는 값의 절대값을 배열에 넣고 계산한다.
// 결과값은 최대 6개이므로 특별한 자료구조를 필요로 하지 않는다.
// 4. 가장 큰 결과를 뽑아낸다.
// 
// 우선순위에 맞게 정리하는 법
// 자기 위치, 숫자
// 자기 위치, 연산자
// 이렇게 자리 정해두고 해도 될 듯
// 첫번째 돌면서 1 순위 연산자 처리
// 연산자만 for loop 돌면서 2 순위 연산자 찾고, 찾으면 그 자리에서 처리
// 


    
    // 1차 고안 : 근데 이러면 6번이긴 해도 매번 char를 돌아야하는 피곤함이 있다.
//     걍 처음 돌면서 배열에 집어넣자.
//     어차피 배열에서 두번 도는건데, 3번도나 2번도나 비슷하면 3번 돌고 긴 for문 한번 도는게 낫지.
//     private void calculate (String expression, char[] level) {
        
//         char[] cArray = expression.toCharArray();
//         int first;
//         int second;
//         char operator;
//         String temp;
//         List<Integer> numbers = new ArrayList<>();
//         List<Character> operators = new ArrayList<>();
//         // int[] numbers = new int[100];
//         // char[] operators = new char[100];
        
//         for (char c : cArray) {
//             if (c > 45) 
//                 temp+=c;
//             else {
//                 if (first == 0)
//                     first = Integer.valueOf(temp);
//                 else
//                     second = Integer.valueOf(temp);
//                 temp = "";
                
//                 if (operator == level[0]) {
//                     // first = first 'level[0]' second;
//                     first = cal(first,second,operator);
//                     // second = 0; 필요없을 듯
//                 }
//                 else {
//                     numbers.add(first);
//                     numbers.add(second);
//                     operators.add(operator);
                    
//                     first = 0;
//                     // second = 0; 필요 없을듯
//                 }
//             }
//         }
            
//         for (int i = 1; i<level.length-1;i++) {
//             do Operate if level[i] == operator
//         }
//         // - : 45 * : 42 + : 43
//     }    
