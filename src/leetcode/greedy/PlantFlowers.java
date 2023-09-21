package leetcode.greedy;

public class PlantFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length;) {
            // 如果当前位置种了, 不管什么情况，都得后移动两个
            if(flowerbed[i] == 1) {
                i += 2;
                continue;
            }
            // 判断当前位置是否能种
            if((i - 1) >= 0 && (i + 1) <= flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                i += 2;
                n --;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        PlantFlowers pf = new PlantFlowers();
        pf.canPlaceFlowers(new int[]{1,0,0,0,0,1},2);
    }
}
