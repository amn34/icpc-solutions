import java.io.*;
import java.util.*;

class Main
{

    public static void main (String args[])  // entry point from OS
    {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int low = in.nextInt();
            int high = in.nextInt();
            int result = result(low, high);
            System.out.println(low + " " + high + " " + result);
        }
    }

    private static int result(int low, int high) {

        if (low > high) { 
            int temp = low;
            low = high;
            high = temp;
        }
        
        int max = 0;
        for(int i = low; i <= high; i++) {
            max = Math.max(max, calculate(i));
        }
        return max;
    }


    private static int calculate(int x) {
        int cycles = 1;

        while (x != 1) {
            if (x % 2 == 1) { 
                x = x * 3 + 1;
            } else { 
                x = x / 2;
            }
            cycles++;
        }
        return cycles;
    }
}