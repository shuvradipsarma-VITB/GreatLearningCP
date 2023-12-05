// Find the element that is present once in an array where
// every other element is present twice

// Input = [1,3,5,6,6,3,1]
// Output = 5


import java.util.*; // it is used to use Arrays class and Scanner class
public class element_present_once
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter length of array");
        int n=sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter elements in the array");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        int result1=check1(arr);
        System.out.println("output="+result1);
        int result2=check2(arr);
        System.out.println("output="+result2);
        int result3=check3(arr);
        System.out.println("output="+result3);
        int result4=check4(arr);
        System.out.println("output="+result4);
    }
    public static int check1(int arr[]) // time complexity - O(n^2) , space complexity - O(n)
    {
        int freq = 1; // acc to qs it is clear that every element is present at least once in the array
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    freq++;
                }
            }
            if(freq<2) return arr[i];
            freq=1;
        }
        return 0;
    }
    // optimised code - time = O(nlogn) , Space complexity=O(1) since no extra space taken
    public static int check2(int arr[])
    {
        // sorting - O(nlogn)
        Arrays.sort(arr); // if arr[]=[1,3,5,6,6,3,1] -> arr[]=[1,1,3,3,5,6,6]
        for(int i=0;i<arr.length-1;i=i+2) // i=i+2 is done since we are checking adjacent position so when its checking
                                       // is done we start checking for next elements which will be present in (i+2)th position
        {
            if(arr[i]!=arr[i+1]) return arr[i]; // if adjacent elements are not same then unique element found
        }
        return 0; // if unique element not present in the array return 0 to "indicate not found"
    }
    // more optimised code - time = O(n) , space = O(n) extra space for using hashmap storing 'n' elements
    /*
    Hashmap approach

    key   - 1, 3, 5, 6
    value - 2, 2, 1, 2

    output = 5 since frequency(value) associated is 1
    */
    public static int check3(int arr[])
    {
        HashMap<Integer,Integer> map = new HashMap<>(); // key is the array element and value is its frequency
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i])) // if key already present then increment its frequency
            {
                map.put(arr[i],map.get(arr[i])+1); // map.get(arr[i]) gives the current frequency (value) associated with the key(arr[i])
            }
            else // if the element(key) appears now in the array i.e its first entry
            {
                map.put(arr[i],1);
            }
        }
        System.out.println(map); // for debugging, to check whether key-value pair stored in hashmap is correct or not
        for(Integer x:map.keySet())
        {
            if(map.get(x)==1) // if there exist a key i.e element whose frequency is 1
            {
                return x; // x is the key i.e arr[i] with freq=1
            }
        }
        return 0; // key i.e arr[i] no found with freq = 1
    }
    // most optimised approach - bitwise operator(XOR)
    //      time complexity = O(n) , space complexity = O(n) no extra space
    // output of xor of same number = 0 and xor of 0 and number>0 is number
    public static int check4(int arr[])
    {
        int xor=0;
        for(int i=0;i<arr.length;i++)
        {
            xor = xor^arr[i];
            System.out.println("at i="+i+", xor = "+xor+" "); // use for debugging check the value of xor for each iteration
        }
        return xor; // returns the value with freq=1
    }
}
