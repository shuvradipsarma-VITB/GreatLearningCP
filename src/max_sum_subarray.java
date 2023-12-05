// find the max sum subarray
// input=[-2,1,5,1,3,-2]
// output = 10 // subarray [1,5,1,3]
// note - negative elements are present

import java.util.Scanner;
public class max_sum_subarray {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.println("enter length of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter elements in the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int result=subarray(arr);
        System.out.println("output="+result);
    }
    //kadane algo---time complexity - O(n) , space - O(1)
    public static int subarray(int arr[])
    {
        int max=Integer.MIN_VALUE;
        int current_sum=0;
        for(int i=0;i<arr.length;i++)
        {
            current_sum=current_sum+arr[i];
            if(current_sum>max)
            {
                max=current_sum;
            }
            if(current_sum<0)
            {
                current_sum=0;
            }
        }
        return max;
    }
}
