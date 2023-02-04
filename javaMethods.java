import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static ArrayList<String> merge(String[] words, String[] more){
        ArrayList<String> listArray = new ArrayList<>();
        for (String w : words) listArray.add(w);
        for(String w : more) listArray.add(w);
        return listArray;
    }
    public static int[] combine(int[] input){
        if(input.length == 0){
            System.out.println("is empty");
        }
        for(int i = input.length - 1; i >= 0; i--){
            if(input[i] == 9){
                input[i] = 0;
            } else {
                input[i] += 1;
                break;
            }
            if(input[i-i] == 0){
                int[] newArray = new int[input.length + 1];
                newArray[0] = 1;
                return newArray;
            }
        }
        return input;
    }
    public static int[] nAdd(int[] data, int n) {
        int sum = 0;
        for(int i = 0; i <= n - 1; i++){
            sum += data[i];
        }
        int[] array = new int[1];
        array[0] = sum;
        return array;
    }
    public static int[] nSum(int[] data, int n) {
        int sum = 0;
        for(int i = 0; i < data.length; i++){
            for(int y = i; y < i + n; y++){
                sum += data[y];
            }
            data[i] = sum;
            sum = 0;
        }
        return data;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] newArray = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    newArray[0] = i;
                    newArray[1] = j;
                }
            }
        }
        return newArray;
    }

    public static boolean isPalindrome(int x) {
        String var = Integer.toString(x);
        char[] input = var.toCharArray();
        char[] store = new char[input.length];
        int count = 0;
        for(int i = input.length - 1; i >= 0; i--){
            store[count] = input[i];
            count++;
        }
        if(Arrays.equals(input,store)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //String[] array = {"this"," is"," my"," test"};
        //String[] info = {"info"," to"," be"," used"};
        //ArrayList<String> result = merge(array,info);
        //System.out.println(result);
        //int[] use = {8,1};
        //int[] result = combine(use);
        //System.out.println(Arrays.toString(result));
        //int[] use = {1,2,3,4,5};
        //int[] result = nSum(use,5);
        //System.out.println(Arrays.toString(result));
        //int[] use = {0,2,0,4};
        //int[] result = twoSum(use,6);
        //System.out.println(Arrays.toString(result));
        int test = 12314;
        boolean result = isPalindrome(test);
        System.out.println(result);
    }
}
