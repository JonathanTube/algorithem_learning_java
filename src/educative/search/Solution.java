package educative.search;

class Solution {
    public int findString(String[] words, String s) {
        return binarySearch(words, 0 , words.length - 1, s);
    }

    private int binarySearch(String[] array, int start, int end, String target) {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(array[mid].equals(target)) return mid;
        
        if(array[mid].equals("")) {
            int result = binarySearch(array, start, mid - 1, target);
            if(result == - 1) {
                result = binarySearch(array, mid + 1, end, target);
            }
            return result;
        }
        if(array[mid].compareTo(target) > 0)  return binarySearch(array, start, mid - 1, target);
        if(array[mid].compareTo(target) < 0) return binarySearch(array, mid + 1, end, target);
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = { "", "educative","" ,"" ,"" , "hello","" , "learning", "world","" , "","" };
        Solution solution = new Solution();
        System.out.println(solution.findString(arr, "educative"));
    }
}