import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    
    //created an ArrayList that took "words" and "more" as parameters and concated them using two for loops.
    public static ArrayList<String> merge(String[] words, String[] more){ //syntax for creating the method merge of type ArrayList<String>
        ArrayList<String> listArray = new ArrayList<>(); //syntax for creating ArrayList listArray that will take both our String Arrays
        for (String w : words) listArray.add(w); //for loop to populate our listArray with the first element of words
        for(String w : more) listArray.add(w); //for loop to populate our listArray with the first element of more
        return listArray; //return listArray
    }
    
    // Define a function that increments each element of an int array by 1 and returns the resulting array.
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
    
    // Define a function that returns an array with a single element that is the sum of the first n elements of an int array.
    public static int[] nAdd(int[] data, int n) {
        int sum = 0;
        for(int i = 0; i <= n - 1; i++){
            sum += data[i];
        }
        int[] array = new int[1];
        array[0] = sum;
        return array;
    }
    
    // Define a function that returns an int array with each element being the sum of the current and the next n-1 elements of an input array.
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
    
    // Define a function that takes an int array and a target number and returns an array with the indices of the elements that add up to the target.
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
    
    // Define a function that takes an array of words and finds the minimum distance between any two repeated words.
    public static void nearestRepeatedWord(String[] input) {
        /*
        //the idea would be to make a hashmap that sets each element of input to a number in order, then
        //simply make another hashmap that has only the duplicates + their respected value and then
        //get the values in variables and subtract from one another.
         If input = {"one", "two", "one", "four"}
         input[0] and input[2] are both "one" so return 2.

         If input = {"one", "two", "three", "four", "four", "two"}
         input[1] and input[5] are both "two", so the distance
         between them is 4.
         But input[3] and input[4] are both "four", so the distance
         between them is 1, which is nearer than 4, so return 1.
        */
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            if(map.containsKey(input[i])){
                array.add(i);
                array.add(map.get(input[i]));
            }
            map.put(input[i],i);
        }
        System.out.println(array);
        ArrayList<Integer> subPairs = new ArrayList<>();
        for(int i = 0; i < array.size() - 1; i++){
            int element = array.get(i);
            if(element > array.get(i + 1)){
                int sub = element - array.get(i + 1);
                subPairs.add(sub);
            }
        }
        System.out.println(subPairs);
        int min = Collections.min(subPairs);
        System.out.println(min);
    }
    public static int howManyGreater(int[] array, int pivot){
        int gtcounter = 0;
        int index = array.length - 1;
        for(int i = array.length - 1; i >= 0;i--){
            if(array[i] > pivot){
                int tmp = array[index];
                array[index] = array[i];
                array[i] = tmp;
                index--;
                gtcounter++;
            }
        }
        return gtcounter;
    }
    public static int[] dutchFlag(int[] array, int pivot){
        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                int tmp = array[counter];
                array[counter] = array[i];
                array[i] = tmp;
                counter++;
            }
        }
        int gttracker = array.length - 1;
        for(int i = array.length - 1; i >= 0; i--){
            if(array[i] > pivot){
                int tmp = array[gttracker];
                array[gttracker] = array[i];
                array[i] = tmp;
                gttracker--;
            }
        }
        return array;
    }
    public static void findPairHash(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                //System.out.println("Pair is (" + nums[i] + "," + nums[map.get(target - nums[i])] + ")");
                pairs.put(nums[i],nums[map.get(target - nums[i])]);
            }
            map.put(nums[i],i);
        }
        if(pairs.isEmpty()){
            System.out.println("No such pair is found.");
        } else {
            for(Map.Entry<Integer,Integer> entry : pairs.entrySet()){
                System.out.println("Pairs are: (" + entry.getKey() + "," + entry.getValue() + ")");
            }
        }

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
    public static int squeezeArrayList(char[] input, Set<Character> delete) {
        if (input == null){
            return 0;
        } else if (delete.isEmpty()){
            return input.length;
        }
        ArrayList<Character> array = new ArrayList<>();
        for (int i = 0; i < input.length; i++){
            array.add(i,input[i]);
        }
        int counter = 0;
        ArrayList<Character> erase = new ArrayList<>();
        for(char s: delete){
            if(array.contains(s)) {
                erase.add(s);
            }
        }
        array.removeAll(erase);
        int calc = (input.length - 1) - erase.size();
        System.out.println(array);
        return calc;
    }
    public static int squeeze(char[] input, Set<Character> delete) {
        if (input == null){
            return 0;
        } else if (delete.isEmpty()){
            return input.length;
        }
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            if (!delete.contains(input[i])) {
                input[counter++] = input[i];
            }
        }
        return counter;
    }
    public static void shuffleWords(String[] words, int[] indexes) {
        int wordslength = words.length;
        int indexeslength = indexes.length;
        if (wordslength != indexeslength){
            return;
        }
        String[] array = new String[wordslength];
        for(int i = 0; i < wordslength; i++){
            array[indexes[i]] = words[i];
        }
        System.out.println(Arrays.toString(array));
        for(int i = 0; i < wordslength; i++){
            words[i] = array[i];
        }
        System.out.println(Arrays.toString(words));
    }
    public static int countNodes(Node head){
        if (head == null){
            return 0;
        }
        int counter = 1;
        Node tracker = head;
        while(tracker.next != null){
            tracker = tracker.next;
            counter++;
        }
        return counter;
    }
    public static Node deleteNode(Node lst, int target){
        if(lst == null || countNodes(lst) == 0){
            return lst;
        }
        Node iter = lst;
        if(lst.val == target){
            Node som = lst.next;
            lst.next = null;
            return som;
        }
        while(iter.next != null){
            if(iter.next.val == target){
                iter.next = iter.next.next;
            }
            iter = iter.next;
        }
        return lst;
    }
    public static int getDecimalValue(Node head) {
        StringBuilder sb = new StringBuilder();
        Node track = head;
        if(head.val == 0 && head.next == null){
            return 0;
        }
        while(track != null){
            sb.append(track.val);
            track = track.next;
        }
        String value = sb.toString();
        System.out.println(value);
        int num = Integer.parseInt(value,2);
        return num;
    }
    public static String restoreString(String s, int[] indices) {
        char[] strArray = s.toCharArray();
        char[] newArray = new char[strArray.length];
        for(int i = 0; i < newArray.length; i++){
            newArray[indices[i]] = strArray[i];
        }
        StringBuilder sb = new StringBuilder();
        String newString = "";
        for(char e:newArray){
            newString = String.valueOf(sb.append(e));
        }
        return newString;
        }

    public static void main(String[] args) {
        String word = "codeleet";
        int[] indexes = new int[]{0,1,0};
        //String result = restoreString(word,indexes);
        //System.out.println(result);
        Node lst = Node.build(indexes);
        int answer = getDecimalValue(lst);
        //int count = countNodes(lst);
        System.out.println(answer);

    }
}
