package educative.slidewindow;

class MinimumSubArraySum{
   public static int minSubArrayLen(int target, int[] nums) {
      int minLen = Integer.MAX_VALUE;
      int start = 0;
      int sum = 0;
      for(int i = 0; i < nums.length; i ++) {
         sum += nums[i];
         while(sum >= target && start <= i) {
            sum -= nums[start];
            minLen = Math.min(minLen, i  - start + 1);
            start ++;
         }
      }
      return minLen == Integer.MAX_VALUE ? 0 :minLen;
   }

   public static void main(String[] args) {
//      System.out.println(minSubArrayLen(7,new int[]{2, 3, 1, 2, 4, 3}));
      System.out.println(minSubArrayLen(10,new int[]{1, 2, 3, 4}));
   }
}