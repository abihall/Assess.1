import java.util.*;

public class ben
{
    public static void main (String[] args)
    {
        Scanner reading = new Scanner(System.in);
        double hours,total=0;
        int i=1;
        while(i <= 5){
            System.out.println("Please Enter the number of hours in week " +i);
            hours = reading.nextDouble();
            while(hours < 0){
                System.out.println("You fucking idiot. Please Enter the number of hours in week " +i);
                hours = reading.nextDouble();
            }
            if(hours > 40)
                total = total + 40*10 + (hours-40)*15;

            else{
                total = total + 10*hours;
            }
            i = i + 1;
        }
        System.out.println("Total salary is: "+total+"\n");
    }
}

