package laboratorytwo;

import java.util.LinkedHashSet;



public class Sample {
    public static void main(String[] args) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int[] arr = {1, 2, 1, 3, 2, 2, 2};
        for (int i = 0; i < arr.length; i++){
            set.add(arr[i]);
    }
        System.out.println(set);

    }
}



