import java.util.Arrays;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        int i = 0;
        while (true) {
            enemy = Arrays.copyOfRange(enemy,0,enemy.length - i);
            Boolean check = iterate(n,k,enemy);
            if (check)
                return enemy.length - i;
            else 
                i++;
        }
    }
    private Boolean iterate (int n, int k, int[] enemy) {
        Arrays.sort(enemy);
        
        enemy = Arrays.copyOfRange(enemy,0,enemy.length - k);
        int sum = 0;
        for (int ene : enemy ) {
            sum += ene;
        }
        if (sum <= n)
            return true;
        else 
            return false;
    }
}


// import java.util.Arrays;
// class Solution {
//     public int solution(int n, int k, int[] enemy) {
        
//         int i = 1;
//         while (true) {
//             int[] enemyLevel = Arrays.copyOfRange(enemy,0,i);
//             Boolean check = iterate(n,k,enemyLevel);
//             if (!check)
//                 return i-1;
//             else if (i == enemy.length)
//                 return i;
//             else 
//                 i++;
//         }
//     }
//     private Boolean iterate (int n, int k, int[] enemy) {
//         Arrays.sort(enemy);
        
//         if (k < enemy.length)
//             enemy = Arrays.copyOfRange(enemy,0,enemy.length - k);
//         else 
//             return true;
    
        
//         int sum = 0;
//         for (int ene : enemy ) {
//             sum += ene;
//         }
        
//         if (sum > n)
//             return false;
//         else 
//             return true;
//     }
// }
