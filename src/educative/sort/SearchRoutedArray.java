package educative.sort;

class SearchRoutedArray {
 static int searchRotatedArray(int arr[], int left, int right, int n) {
  // Write your code here
  if(left > right) return -1;
  int mid = (left + right) / 2;
  if(arr[mid] == n) return mid;

  if(arr[left] < arr[mid]) { // left is ordered
    if(n>= arr[left] && n < arr[mid]) { // the n is int the left range.
        return searchRotatedArray(arr, left, mid - 1, n);
    }else { // search the right
        return searchRotatedArray(arr, mid + 1, right, n);
    }
  }else if(arr[mid] < arr[right]) { // right is ordered.
    if(n > arr[mid] && n <= arr[right]) { // search in the right range.
        return searchRotatedArray(arr, mid + 1, right, n);
    }else { // search the left
        return searchRotatedArray(arr, left, mid - 1, n);
    }
  }else if(arr[mid] == arr[left] && arr[mid] != arr[right]) { // if the left part is all repeats.
        return searchRotatedArray(arr, mid +1, right, n);
  }else if(arr[mid] != arr[left] && arr[mid] == arr[right]) {
         return searchRotatedArray(arr, left, mid - 1, n);
  }else {
      int result = searchRotatedArray(arr, left, mid - 1, n);
      if(result == -1) {
          return searchRotatedArray(arr, mid +1, right, n);
      }
      return result;
  }
 }

    public static void main(String[] args) {
//        int[] arr = {7, 8, 9, 0, 3, 5, 6};
        int[] arr = {40,100,-100,40,0,24,40};
        System.out.println(searchRotatedArray(arr,0 , 6,-100));
    }
}