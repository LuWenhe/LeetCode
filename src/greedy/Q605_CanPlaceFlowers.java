package greedy;

public class Q605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] arr = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, arr, 1, flowerbed.length);

        for(int i = 1; i < arr.length - 1; i++){
            // 连续出现三个 0 就可以栽上一棵花
            if(arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0){
                arr[i] = 1; // 在 i 处栽上花
                n--;
            }
        }

        return n <= 0; // n 小于等于 0 ，表示可以栽完花
    }

    public static void main(String[] args) {
        int[] flowerbed = {0, 0};
        int n = 2;
        boolean res = new Q605_CanPlaceFlowers().canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }

}
