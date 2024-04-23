package site.debug;

public class Debug03 {
    public static void main(String[] args){
      int[] arr =  new int[]{1,2,3};
        for (int i = 0; i < arr.length; i++) {
            int tar = arr[i];
            System.out.println(tar);
        }

//        for (int i : arr) {
//            int tar = arr[i];
//            System.out.println(tar);
//        }
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int tar = arr[i];
//            System.out.println(tar);
//        }
    }
}
