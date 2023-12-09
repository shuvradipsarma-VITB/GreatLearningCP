import java.util.*;
public class next_greater_element_circular_array {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("n=");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter elements in the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>(n);
        ArrayList<Integer> result = nge(arr,list);
        System.out.println("output=" + result);
    }
    public static ArrayList<Integer> nge(int arr[],ArrayList<Integer> list)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i=2*arr.length-1;i>=0;i--)
        {
            while(stack.isEmpty()!=true && arr[i % arr.length]>=stack.peek())
            {
                stack.pop();
            }
            if(i<arr.length){
                if(stack.isEmpty()==true)
                {
                    list.add(0,-1);
                }
                else
                {
                    list.add(0,stack.peek());
                }
            }
            stack.push(arr[i % arr.length]);
        }
        return list;
    }
}
