package educative.greedy;

public class JumpGame{
   public static boolean jumpGame(int[] nums) {
      int last = nums.length - 1; // 4
      for(int i = nums.length - 2; i >= 0; i--) {
         if(i + nums[i] >= last) last = i;
         if(last == 0) return true;
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(jumpGame(new int[]{4,0,0,0,4}));
   }
}