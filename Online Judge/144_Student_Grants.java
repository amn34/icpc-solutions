//144 Student Grants
import java.io.*;
import java.util.*;

class Main
{

    public static void main (String args[])  // entry point from OS
    {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int numStudent = in.nextInt();
            int maxDispense = in.nextInt();

            if(numStudent == 0 && maxDispense == 0) return;
            giveMoney(numStudent, maxDispense);
        }
    }

    private static void giveMoney(int numStudent, int maxDispense) {

        int[] money = new int[numStudent+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= numStudent; i++) {
            queue.offer(i);
        }

        int storedMoney = 1;
        int dispenseAmount = 1;
        while(!queue.isEmpty()) {
            int student = queue.poll();
            int withdraw = Math.min(storedMoney, 40 - money[student]);
            money[student] += withdraw;

            storedMoney -= withdraw;
            if(storedMoney == 0) {
                dispenseAmount = dispenseAmount < maxDispense ? dispenseAmount + 1 : 1;
                storedMoney += dispenseAmount;
            }

            if(money[student] < 40) {
                queue.offer(student);
            }
            else {
                if(queue.size() == 0) {
                    System.out.print(student);
                } else {
                    System.out.print(student + " ");                    
                }

            }
        }
        System.out.println();
    }
}