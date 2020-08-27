package exam;


import org.junit.Test;

import java.sql.PreparedStatement;
import java.util.*;

public class exam {

    List<String> testlist = new ArrayList<>();

//    @Test
    public void test1(){
        int[] nums = new int[3];
        int length = addOne(nums);
        for(int n : nums){

            System.out.println(n);
        }

        System.out.println(length);
    }

    public static int addOne(int[] arr){
        int cnt =0;
        for(int i=0; i<arr.length; i++){
            arr[i]++;
            cnt++;
        }
        return cnt;
    }

//    @Test
    public void test2(){
        int[] nums = new int[]{9,4,0,-1,4,22,-100,2};
        int result =0;
        for(int i=0;i <nums.length; i++){
            result = Math.max(result,nums[i]);

        };
        System.out.println(result);
    }

//    @Test
    public void test3(){

        int sum =0;
        for(int i=0; i<10; i+=2){
            sum+=i;
            System.out.println(i);
        }
        System.out.println(sum);
    }
}
