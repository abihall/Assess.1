import java.util.Scanner;

    import java.util.*;

    public class AgencyInterface
    {
        private void run()
        {
            Scanner console = new Scanner(System.in);
            Couple c = new Couple();
            int      age=0,end;
            String   name;

            do {
                System.out.print("first person: ");
                System.out.print("name: ");
                name = console.next();
                inputAge(console);
                c.addData(1,name,age);

                System.out.print("second person: ");
                System.out.print("name: ");
                name = console.next();
                inputAge(console);
                c.addData(2,name,age);

                System.out.println("********************");
                System.out.println(c.test());
                System.out.println("********************");
                System.out.print("Quit? (0)yes (1)no: ");
                end = console.nextInt();
            }
            while (end!=0);
        }
        public static void main(String[] args)
        {
            AgencyInterface agency = new AgencyInterface();
            agency.run();
        }
        public int inputAge(Scanner y)
        {
            int age;
            do{
                System.out.print("What is their age: ");
                age = y.nextInt();
            } while(age<18);
            return(age);
        }

    }

