import java.util.*;
public class element_present_once_already_sorted {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter length of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter elements in the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //arr = [1,1,3,5,6,6,3]
        // elements are sorted
        Arrays.sort(arr); // arr = [1,1,3,3,5,6,6]

        int  result1 = check1(arr);
        System.out.println("output="+result1);

        int result2 = check2(arr,0,arr.length-1);
        System.out.println("output="+result2);

        int result3 = check3(arr,0,arr.length-1);
        System.out.println("output="+result3);

    }
    // approach 1 - using loops
    // time complexity = O(n), space complexity = O(1) no extra space
    public static int check1(int arr[])
    {
        // arr = [1,1,3,3,5,6,6]
        for(int i=0;i<arr.length;i=i+2) // i=i+2 is done since elements are present twice except one
        {
            if(arr[i]!=arr[i+1])
            {
                return arr[i]; // if adjacent element not same
                            // that indicates unique element found
            }
        }
        return 0; // unique element not found
    }
    // using two pointer approach
    // time complexity - O(n), space complexity - O(1)
    public static int check2(int arr[],int low,int high)
    {
        // arr = [1,1,3,3,5,6,6]
        while(low<high)
        {
              if(low<high && arr[low]!=arr[low+1])
              {
                  return arr[low];
              }
              if(low<high && arr[high]!=arr[high-1])
              {
                  return arr[high];
              }
              // pointer movement by 2 one from left to right and one right to left
              low = low+2;
              high = high-2;
        }
        return 0;
    }
    // binary search can be implemented since array sorted already
    // time complexity - O(log n) and space comlexity - O(1)
    public static int check3(int arr[],int low,int high)
    {
        while(low<high)
        {
            int mid = (low + high)/2;

            if((mid % 2 == 0) && (arr[mid]==arr[mid+1]))
            {
                low = mid+2;
            }
            else if((mid % 2 == 0) && (arr[mid]!=arr[mid+1]))
            {
                high = mid;
            }
            else if((mid % 2 !=0) && (arr[mid]==arr[mid-1]))
            {
                low = mid+1;
            }
            else if((mid % 2 !=0) && (arr[mid]!=arr[mid-1]))
            {
                high = mid-1;
            }
            System.out.println("low=" + low + " , " + "high=" + high); // for debugging checking the movement of low and high pointer
        }
        return arr[low]; // unique element
    }
}
