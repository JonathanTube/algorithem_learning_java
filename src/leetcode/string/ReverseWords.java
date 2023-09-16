package leetcode.string;

public class ReverseWords {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        printArr(arr, -1, -1);
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            System.out.println("fast = " + fast + " slow=" + slow);
            printArr(arr, slow, fast);
            if (arr[fast] != ' ') arr[slow++] = arr[fast];
            else {
                if (slow > 0) {
                    if (arr[slow - 1] != ' ') {
                        arr[slow] = ' ';
                        slow++;
                    }
                }
            }
        }
        printArr(arr, -1, -1);
        reverseArr(arr, 0, slow - 1);
        printArr(arr, -1, -1);


//        int start = 0;
//        int end = 1;
//        while (end < slow) {
//            while (end < slow && arr[end] != ' ') end++;
//            System.out.println("start=" + start + " end=" + end);
//            reverseArr(arr, start, end - 1);
//            printArr(arr);
//            start = end + 1;
//            end++;
//        }

        return new String(arr);
    }

    private void reverseArr(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private void printArr(char[] arr, int slow, int fast) {
        for (int i = 0; i < arr.length; i++) {
            if (i == slow) System.out.print("[" + arr[i] + "]->");
            else if (i == fast) System.out.print("{" + arr[i] + "}->");
            else System.out.print(arr[i] + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords("  hello world  ");
        System.out.println(result);
    }
}
