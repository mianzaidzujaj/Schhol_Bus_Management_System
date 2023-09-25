import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter who you are");
        System.out.println("1: Manager \n2: Student\n3: Driver\n0: exit");
        int input1 = input.nextInt();
        while (input1 != 0) {
            System.out.println("1: Manager \n 2: Driver \n 3: Student \n 0:exit");
            switch (input1) {
                case 1:
                    Manager m = new Manager();
                    int ManagerChoice = 3;
                    while (ManagerChoice != 0) {
                        System.out.println("1: SignUp\n 2: login \n0: exit");
                        ManagerChoice = input.nextInt();
                        if (ManagerChoice == 1)
                            m.SignUp();
                        else if (ManagerChoice == 2)
                            m.login();
                        else
                            break;

                    }
                    break;
                case 2:
                    Student s = new Student();
                    int StudentChoice = 3;
                    while (StudentChoice != 0) {
                        System.out.println("1: SingUp \n2: Login \n 0:exit");
                        StudentChoice = input.nextInt();
                        if (StudentChoice == 1)
                            s.SignUp();
                        else if (StudentChoice == 2)
                            s.Login();
                        else
                            break;
                    }
                    break;
                case 3:
                    Driver d = new Driver();
                    int DriverChoice = 3;
                    while (DriverChoice != 0) {
                        System.out.println("1: SingUp \n2: Login \n 0:exit");
                        DriverChoice = input.nextInt();
                        if (DriverChoice == 1)
                            d.SignUp();
                        else if (DriverChoice == 2)
                            d.Login();
                        else
                            break;
                    }
                    break;
                default:  break;

            }
        }
    }
}


