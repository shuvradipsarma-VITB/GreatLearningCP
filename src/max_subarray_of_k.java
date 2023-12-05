// Find the max sum subarray of size k (note- subarray is contagious)
// input - arr[] = [2,1,5,1,3,2] , k=3
// output = 9 ( subarray - [5,1,3] )
import java.util.Scanner;
public class max_subarray_of_k
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.println("n=");
        int n=sc.nextInt();
        System.out.println("k=");
        int k=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter elements in the array");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        // brute force output
        int result1 = subarray(arr,k);
        System.out.println("output="+result1);

        // sliding window output
        int result2 = sliding_window(arr,k);
        System.out.println("output="+result2);
    }
    // brute force approach
    // time complexity - O(n^2) , space compelxity-O(1)
    public static int subarray(int arr[],int k)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-k+1;i++)
        {
            int s=0;
            for(int j=0;j<k;j++)
            {
                s=s+arr[i+j];
            }
            max = Math.max(max,s);
        }
        return max;
    }
    // sliding window algorithm
    // time complexity - O(n) , space compplexity - O(1)
    public static int sliding_window(int arr[],int k)
    {
        int sum=0, max=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<arr.length-1)
        {
            sum = sum + arr[j];
            if(j-i+1 < k)
            {
                j++;
            }
            else if(j-i+1 == k) // window size hit!
            {
                max = Math.max(max,sum);
                sum = sum - arr[i]; // remove the ith element from sum
                i++; // go to next index (to maintain k)
                j++; // go to next index (to maintain k)
            }
        }
        return max;
    }

}
