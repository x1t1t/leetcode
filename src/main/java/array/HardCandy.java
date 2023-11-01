package array;

public class HardCandy {

    public static void main(String[] args) {
        int[] ratings = {1 ,0,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        int total =0;
        for(int i = 0; i<ratings.length; i++){
            if(i>0 && ratings[i] > ratings[i-1]) {
                left[i] =left[i-1]+1;
            } else {
                left[i] =1;
            }
        }

        for(int j=ratings.length-1; j>=0; j--){
            if(j<ratings.length-1 && ratings[j] > ratings[j+1]) {
                right[j] =right[j+1]+1;
            } else {
                right[j] =1;
            }
            total+= Math.max(left[j], right[j]);
        }
        return total;
    }
}
