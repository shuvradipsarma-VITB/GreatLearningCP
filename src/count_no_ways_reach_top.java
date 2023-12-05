// count no. of ways to reach the top. You can take either 1 or 2 step at a time
import java.util.Scanner;
public class count_no_ways_reach_top {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.println("n="); // n is no. of stairs
        int n=sc.nextInt();
        System.out.println("output="+count(n));
    }
    public static int count(int n)
    {
        if(n<=1)
        {
            return 1;
        }
        else {
            return count(n-1)+count(n-2);
        }
    }
}
