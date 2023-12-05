// no. of binary string without consecutive 1's
//input- N = 2 (length of string)
// output - 3 // strings are 00,01,10,11

import java.util.Scanner;
public class binary_strings_without_consecutive_one
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.println("N=");
        int n=sc.nextInt();

        int result=consecutive_1s(n);
        System.out.println("output="+result);
    }
    public static int consecutive_1s(int n)
    {
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 2;
        }
        if(n==2)
        {
            return 3;
        }
        return consecutive_1s(n-1)+consecutive_1s(n-2);
    }
}
