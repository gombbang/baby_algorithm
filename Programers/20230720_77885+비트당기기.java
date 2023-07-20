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
