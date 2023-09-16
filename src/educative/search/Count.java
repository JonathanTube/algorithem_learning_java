package educative.search;

class Count {
 public static int calcFreq(int arr[], int key) {
    int times = 0;
  if(arr.length == 0) return times;
  int first = 0;
  int last = arr.length - 1;
  while(first < last) {
      int mid = (first+last) / 2;
      if(arr[mid] == key) {
          times ++;
          if(arr[mid - 1] == arr[mid] && arr[mid + 1] != arr[mid]) {
              last = mid - 1;
          }else if(arr[mid - 1] != arr[mid] && arr[mid + 1] == arr[mid]) {
              first = mid + 1;
          }
          continue;
      }
      if(arr[mid] < key) { // search right
        first = mid + 1;
        continue;
      }
      if(arr[mid] > key) { // search left
        last = mid - 1;
        continue;
      }
  }
  return times;
 }

    public static void main(String[] args) {
        int[] arr = {-5,-3,0,1,3,3,3,4,5};
        System.out.println(calcFreq(arr, 3));

        System.out.println("".compareTo("b"));
    }
}