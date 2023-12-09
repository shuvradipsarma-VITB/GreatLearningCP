// find the next greater element present to right for each element
// Input = [2,1,5,1,3,2]
// Output = [5,5,-1,3,-1,-1]
// if nge to its right not present put "-1"
// Note- donot consider arraylist for storing the result as space complexity
import java.util.*;
public class next_greater_element {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.println("n=");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter elements in the array");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> list1 = new ArrayList<>(n);
        ArrayList<Integer> list2 = new ArrayList<>(n);
        ArrayList<Integer> result1 = nge_1(arr,list1); // since return type list so result is arraylist type
        System.out.println("output="+result1);
        ArrayList<Integer> result2 = nge_2(arr,list2);
        System.out.println("output="+result2);

    }
    // brute force approach, time complexity-O(n^2) , space-O(1) extra space
    public static ArrayList<Integer> nge_1(int arr[],ArrayList<Integer>list)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int flag=0; // to check if nge present or not for current element - arr[i]
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]>arr[i])
                {
                    list.add(arr[j]);
                    flag=1; // toggle the flag indicating nge present for current element
                    break;
                }
            }
            if(flag==0) // if flag==0 that means nge not present
                list.add(-1);
        }
        list.add(-1); // for the last element nge to right is not possible
        return list;
    }
    public static ArrayList<Integer> nge_2(int arr[],ArrayList<Integer> list)
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list.add(0, stack.peek()); // Add elements at the beginning to preserve order
            } else {
                list.add(0, -1);
            }

            stack.push(arr[i]);
        }

        return list;
    }
}
