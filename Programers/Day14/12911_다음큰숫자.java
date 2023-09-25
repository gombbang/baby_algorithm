class Solution {
//     public static int solution(int n) {
//         int count = Integer.bitCount(n);

//         return findNextBiggerNumber(count, n);
//     }

//     private static int findNextBiggerNumber(int count, int n) {
//         while (true) {
//             n++;
//             int binaryCount = Integer.bitCount(n);

//             if (binaryCount == count) {
//                 return n;
//             }
//         }
//     }
    public static int solution (int n) {
        String str = Integer.toBinaryString(n);
        char[] cs = str.toCharArray();
        int count = 0;
        for (char c : cs) {
            if (c == '1')
                count++;
        }
        int temp=-1;
        while (count != temp) {
            temp = 0;
            n++;
            char[] cc = Integer.toBinaryString(n).toCharArray();
            
            for (char c : cc) {
                if (c == '1')
                    temp++;
            }
        }
        return n;
    }
}
