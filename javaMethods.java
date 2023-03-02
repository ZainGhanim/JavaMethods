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
    
    //--------------------------------------- Linked Lists -------------------------------------------------
    public static node build(int[] input) {
        node head = new node(-1, (node)null);
        node curr = head;
        int[] var3 = input;
        int var4 = input.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            int i = var3[var5];
            curr.next = new node(i, (node)null);
            curr = curr.next;
        }

        return head.next;
    }
    
    public static node delete(node lst, int target) {
        if (lst == null) return null;
        if (lst.val == target) {
            node retVal = lst.next;
            lst.next = null;
            return retVal;
        }
        node iter = lst;
        while (iter.next != null) {
            // do some work
            if (iter.next.val == target) {
                iter.next = iter.next.next;
            }
            iter = iter.next;
        }
        return lst;
    }
    
    public boolean hasCycle(node lst) {
        if (lst == null) return false;
        node slow = lst;
        node fast = lst.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    
    public node merge(node l1, node l2) {
        node dummy = new node(-1, null);
        node iter = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if (l1 != null) iter.next = l1;
        if (l2 != null) iter.next = l2;
        return dummy.next;
    }
    
    public int add(node lst1, node lst2){
        int sum1 = 0;
        int factor = 1;
        while(lst1 != null){
            sum1 += lst1.val = factor;
            factor *= 10;
            lst1 = lst1.next;
        }
        int sum2 = 0;
        factor = 1;
        while(lst2 != null){
            sum2 += lst2.val * factor;
            factor *= 10;
            lst2 = lst2.next;
        }
        return sum1 + sum2;
    }
    
    public static node partition(node head, int x) {
        node lt = new node(-1,null);
        node ltHead = lt;
        node gt = new node(-1,null);
        node gtHead = gt;
        while(head != null){
            if(head.val < x){
                ltHead.next = head;
                ltHead = ltHead.next;
            } else {
                gtHead.next = head;
                gtHead = gtHead.next;
            }
        }
        ltHead.next = gt.next;
        return ltHead.next;
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
    
    public node kthLast(node input, int k) {
        int counter = 0;
        node head = input;
        while(head != null){
            counter++;
            head = head.next;
        }
        if (k > counter || k <= 0){
            return input;
        } else if (input == null) {
            return null;
        }
        node save = null;
        node tracker = input;
        while(tracker != null){
            if(counter == k){
                save = tracker;
            }
            counter--;
            tracker = tracker.next;
        }
        return save;
    }
    
    public node thirdList(node lst){
        node first = lst;
        node third = lst;
        for(int i=0; i<3 && third != null; i++){
            third = third.next;
        }
        while(third != null){
            first = first.next;
            third = third.next;
        }
        return first;
    }

    //lst is sorted
    public node removeDups(node lst){
        if(lst == null) return null;
        node iter = lst;
        while(iter != null){
            while(iter.next != null && iter.next.val == iter.val){
                iter.next = iter.next.next;
            }
            iter = iter.next;
        }
        return lst;
    }
    
    public static int count(node head) {
        int count = 1;
        for(node current = head; current.next != null; ++count) {
            current = current.next;
        }
        return count;
    }
    
    //ideas that backup the OddEvenList question
    public static Node merge(Node one, Node two){
        Node dummy = new Node(-1,null);
        Node pointer1 = dummy;
        int i = 1;
        while(one != null && two != null){
            if(i % 2 == 0){
                pointer1.next = one;
                one = one.next;
            } else {
                pointer1.next = two;
                two = two.next;
            }
            pointer1 = pointer1.next;
            i++;
        }
        if(one != null){
            pointer1.next = one;
        }
        if(two != null){
            pointer1.next = two;
        }
        return dummy.next;
        //code in phone
    }
    
    public static Node split(Node input){
        Node one = new Node(-1,null);
        Node pointer1 = one;
        Node two = new Node(-1,null);
        Node pointer2 = two;
        int i = 1;
        while(input != null){
            if(i % 2 == 0){
                pointer1.next = input;
                input = input.next;
                pointer1 = pointer1.next;
                if(input == null){
                    pointer2.next = null;
                }
            }else{
                pointer2.next = input;
                input = input.next;
                pointer2 = pointer2.next;
                if(input == null){
                    pointer1.next = null;
                }
            }
            i++;
        }
        System.out.println(one.next);
        return two.next;
    }
    
    // LeetCode Medium OddEvenList Question
    public ListNode oddEvenList(ListNode head) {
        ListNode one = new ListNode(-1, null);
        ListNode pointer1 = one;
        ListNode two = new ListNode(-1,null);
        ListNode pointer2 = two;
        int i = 1;

        while(head != null){
            if(i % 2 == 0){
                pointer1.next = head;
                head = head.next;
                pointer1 = pointer1.next;
                if (head == null){
                    pointer2.next = null;
                }
            } else{
                pointer2.next = head;
                head = head.next;
                pointer2 = pointer2.next;
                if (head == null){
                    pointer1.next = null;
                }
            }
            i++;
        }
        pointer2.next = one.next;
        return two.next;
    }
    
    // Leetcode Medium swapPairs Question
    public ListNode swapPairs(ListNode head) {
        ListNode one = new ListNode(-1, null);
        ListNode pointer1 = one;
        ListNode two = new ListNode(-1,null);
        ListNode pointer2 = two;
        int i = 1;

        while(head != null){
            if(i % 2 == 0){
                pointer1.next = head;
                head = head.next;
                pointer1 = pointer1.next;
                if(head == null){
                    pointer2.next = null;
                }
            } else {
                pointer2.next = head;
                head = head.next;
                pointer2 = pointer2.next;
                if(head == null){
                    pointer1.next = null;
                }
            }
            i++;
        }

        ListNode three = new ListNode(-1,null);
        ListNode pointer3 = three;
        i = 1;

        while(one.next != null && two.next != null){
            if(i % 2 == 0){
                pointer3.next = two.next;
                two.next = two.next.next;
                pointer3 = pointer3.next;
            } else {
                pointer3.next = one.next;
                one.next = one.next.next;
                pointer3 = pointer3.next;
            }
            i++;
        }

        if(one.next != null){
            pointer3.next = one.next;
        }
        
        if(two.next != null){
            pointer3.next = two.next;
        }

        return three.next;
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
