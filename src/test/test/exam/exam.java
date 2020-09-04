package exam;


import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

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

    @Test
    public void testCalendar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer("10 5");
        int count = Integer.valueOf(tokenizer.nextToken());
        int num = Integer.valueOf(tokenizer.nextToken());

        System.out.println(count +" / "+num);

        tokenizer = new StringTokenizer("1 10 4 9 2 3 8 5 7 6");

        for(int i=0; i<count; i++){

            int intNum = Integer.valueOf(tokenizer.nextToken());
            if(intNum < num){
                if(i != count-1){
                    builder.append(intNum +" ");
                }else{
                    builder.append(intNum);
                }
            }
        }
        writer.write(builder.toString());
        writer.flush();
    }
}
