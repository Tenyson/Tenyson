package Java基础.内部类.示例;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: dc
 * Date: 2018-12-06
 * Time: 9:47 AM
 */
public class MapTest {


    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    public static void main(String[] args) {
        MapTest test  = new MapTest();
        int[] nums = new int[]{2,15,11,7};
        int[] result = test.twoSum(nums,9);
        System.out.println(Arrays.toString(result));
    }
}
