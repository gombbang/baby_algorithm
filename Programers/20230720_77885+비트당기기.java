class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        for (long number : numbers) {
            answer[index++]= numberProcess(number);
        }
        
        return answer;
    }
    
    private long numberProcess(long number) {
        long answer = 0;
        
        Boolean twoFlag = true;
        if ((int)(number % 2) == 1)
            twoFlag = false;
        
        String numToBinary = '0' + Long.toBinaryString(number);
        
        char[] numBinaryArray = numToBinary.toCharArray();
        int index = 0;
        for (int i = numBinaryArray.length-1; i>=0; i--) {
            char binary = numBinaryArray[i];
            if (binary=='0') {
                numBinaryArray[i]='1';
                
                if (!twoFlag) {
                    numBinaryArray[i+1] = '0';
                }
                break;
            }
        }
        numToBinary = new String(numBinaryArray);
        // System.out.println("numToBinary : " + numToBinary);
        
        
        return Long.parseLong(numToBinary, 2);
        // return 100;
    }
}

// 패착 1 : binary 함수 만들다가 멘 붕
// 패착 2 : 홀수 짝수 구분 에 대한 생각 부족





// import java.util.Arrays;
// import java.math.*;

// class Solution {
    
//     private Boolean[] bits;
    
//     private void init() {
//         for (Boolean bit : bits) 
//             bit = false;
//     }
    
//     private Long pow (int base, int top) {
//         Long ret=Integer.toUnsignedLong(1);
//         for (int i = 0; i < top; i++)
//             ret *= base;
//         return ret;
//     }
    
//     private int findN (Long data) {
//         int ret = 0;
//         while (true) {
//             ret ++;
//             if (data < pow(2,ret))
//                 break;
//         }
//         return ret;
//     }
    
//     private int convert (long number){
//         int index = 0;
//         int flag = (int)(number % 2);
//             while(number > 1) {
//                 // System.out.println("number : " + number);
                
//                 bits[index++] = true;
//                 number = (long)(number / 2);
                
//                 // System.out.println("number : " + number);
//             } 
//             if (flag == 0)
//                 bits[index] = false;
//             else 
//                 bits[index] = true;
            
//             // String bitString = "";
//             // for (Boolean bit : bits) {
//             //     if (bit != null) {
//             //     if (bit == false)
//             //         bitString += "0";
//             //     else
//             //         bitString += "1";
//             //     }
//             // }
//             // System.out.println("bits : " + bitString);
//             init();
        
//         return index;
//     }
    
//     public long[] solution(long[] numbers) {
//         long[] answer = new long[numbers.length];
        
//         // init();
//         int size = numbers.length;
//         Long numberSize = pow(10,15);
        
//         int bitSize = findN(numberSize)+1;
//         bits = new Boolean[bitSize];
//         // System.out.println("2의 n배수로 표현 가능 : " + bitSize);
//         init();
        
//         int index = 0;
        
//         for (long number : numbers) {
//             int realBitSize = convert(number);
//             // System.out.println("size : " + realBitSize);
//             if (bits[realBitSize] == false) {
//                 answer[index++] = number+1;
//             } else if(bits[realBitSize-1] == false)
//                  answer[index++] = number+2;
//             else {
//                 answer[index++]= bitsSolution(realBitSize, number);
//             }
//         }
        
//         return answer;
//     }
    
    
//     private long bitsSolution(int bitSize, long number) {
//         int flag = 0;
//         int targetNumber = 0;
//         long answer = 0;
//         while (true) {
//             if (bits[bitSize - targetNumber] == false)
//                 break;
//             else if (++targetNumber == bitSize) {
//                 flag = 1;
//                 break;
//             }
//         }
//         targetNumber++;
//         // System.out.println("마지막 1의 위치== 0이 될 위치,targetNumber : " + targetNumber);
//         if (targetNumber == 1)
//             return (long)number + 1;
//         else {
// //             flag == 0 : 앞에 더 있음
//             if (flag == 0) {
//                 int sqrt = bitSize;
//                 while (targetNumber < sqrt) {
//                     answer += pow(2,sqrt--);
//                 }
//                 for(int count = 0; count < targetNumber -1 ; count++) {
//                     answer += pow(2,count);
//                 }
//             } else {
//                 answer = pow(2,targetNumber);
//                 for(int count = 0; count < targetNumber -1 ; count++) {
//                     answer += pow(2,count);
//                 }
//             }
//         }
//         return answer;
//     }
// }

