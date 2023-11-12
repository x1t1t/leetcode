package array;

public class HardTrap {

    public static int trap(int[] height) {
        int total = 0;
        for(int i=1; i<height.length-1; i++) {
            int maxLeft=0,maxRight=0,l=i-1,r=i+1;
            while(l >= 0){
                maxLeft = Math.max(maxLeft,height[l]);
                l--;
            }
            while(r < height.length){
                maxRight = Math.max(maxRight,height[r]);
                r++;
            }
            int maxHigh = Math.min(maxLeft, maxRight);
            if (maxHigh > height[i]){
                total+=(maxHigh - height[i]);
            }
        }
        return total;
    }
}
