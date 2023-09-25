import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class Manager extends Person {
    String post;
    String manager_cnic;
    int service_time;
    File ManagerFile = new File("C:\\Users\\aaa\\oop-java\\final_3rdsem_java\\Manager.txt");
    ArrayList<Manager> ManagerList = new ArrayList<Manager>();
    ListIterator li = null;
    ObjectOutputStream Manageroos = null;
    ObjectInputStream Managerois = null;
    Scanner input = new Scanner(System.in);

    Manager() {
        super();
        post = "";
        manager_cnic = "";
        service_time = 0;
    }

    Manager(String name, int age, String adress, String unique_id, String pass, String phone_no,
            String post, String manager_cnic, int service_time) {
        super(name, age, adress, phone_no, unique_id, pass);
        this.post = post;
        this.service_time = service_time;
        this.manager_cnic = manager_cnic;

    }

    void setPost(String post) {
        this.post = post;
    }

    String getPost() {
        return post;
    }

    void setManager_cnic(String manager_cnic) {
        this.manager_cnic = manager_cnic;
    }

    String getManager_cnic() {
        return manager_cnic;
    }

    void setService_time(int service_time) {
        this.service_time = service_time;
    }

    int getService_time() {
        return service_time;
    }


    @Override
    public String toString() {
        return
                "Manager id = " + getUnique_id() +
                        "Manager name = " + getName() +
                        "Manager age = " + getAge() +
                        "Manager adress = " + getAdress() +
                        "manager password =" + getPassword() +
                        "manager cnic =" + manager_cnic +
                        "service years = " + service_time +
                        "Manager post = " + post;
    }

    @Override
    void SignUp() {
        super.SignUp();
        System.out.println("Enter your CNIC");
        this.manager_cnic = input.next();
        System.out.println("Enter Manager service time");
        this.service_time = input.nextInt();
        System.out.println("Enter post of Manager");
        this.post = input.next();
        ManagerList.add(new Manager(getName(), getAge(), getAdress(), getPhone_no(),
                getUnique_id(), getPassword(), post, manager_cnic, service_time));
        System.out.println("done");
            try {
                Manageroos = new ObjectOutputStream(new FileOutputStream(ManagerFile));
                Manageroos.writeObject(ManagerList);
                System.out.println("done");

            } catch (IOException e) {
                e.getStackTrace();
            }
    }

    void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your unique ID");
        String uniqId = input.next();
        System.out.println("enter your password");
        String password = input.next();
            try {
                if (ManagerFile.isFile()) {
                    Managerois = new ObjectInputStream(new FileInputStream(ManagerFile));
                    ManagerList = (ArrayList<Manager>) Managerois.readObject();
                    Managerois.close();
                    li = ManagerList.listIterator();
                    boolean chek = false;
                    Manager m = (Manager) li.next();
                    while (li.hasNext()) {
                        if (m.getUnique_id().equals(uniqId) && m.getPassword().equals(password)) {
                            System.out.println("true");
                            chek = true;
                            break;
                        }else
                            System.out.println("sorry");
                    }
                    if (chek == true) {
                        System.out.println("1: ADD STUDENT\n2: ADD DRIVER\n3: ADD BUS\n" +
                                "4: VIEW STUDENTS\n5: VIEW DRIVERS\n6: VIEW BUSES\n0: EXIT");
                        int choice = input.nextInt();
                        do {

                            switch (choice) {
                                case 1:
                                    Student s = new Student();
                                    s.SignUp();
                                    break;
                                case 2:
                                    Driver d = new Driver();
                                    d.SignUp();
                                    break;
                                case 3:
                                    //addBus();
                                    break;
                                case 4:
                                    managerViewStudent();
                                    break;
                                case 5:
                                    managerViewDriver();
                                    break;

                            }
                            break;
                        } while (choice != 0);
                    } else {
                        System.out.println("Wrong ID or password");
                    }
                }
            } catch (IOException e) {

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        void managerViewDriver(){
            Driver d = new Driver();
            try {
                if (d.DriverFile.isFile()) {
                    d.Driverois = new ObjectInputStream(new FileInputStream(d.DriverFile));
                    d.DriverList = (ArrayList<Driver>) d.Driverois.readObject();
                    d.Driverois.close();
                    li = d.DriverList.listIterator();
                    while (li.hasNext()) {
                        d = (Driver) li.next();
                        d.toString();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);

            }
        }
        void managerViewStudent(){
            Student s = new Student();
            try {

                if (s.StudentFile.isFile()) {
                    s.Studentois = new ObjectInputStream(new FileInputStream(s.StudentFile));
                    s.StudentList = (ArrayList<Student>) s.Studentois.readObject();
                    s.Studentois.close();
                    li = s.StudentList.listIterator();
                    while (li.hasNext()) {
                        s = (Student) li.next();
                        s.toString();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {

            }
        }

    void AddBus(){
        Bus b=new Bus();
        System.out.println("enter bus regestration number");
        b.setBus_regestration_num(input.next());
        System.out.println("enter bus number");
        b.setBus_number(input.nextInt());
        System.out.println("enter bus capacity");
        b.setBus_capacity(input.nextInt());
        System.out.println("enter bus driver name");
        Driver d=new Driver();
        //b.setBus_driver(d.SignUp());
        System.out.println("enter bus route");
        b.setBus_route(input.next());
    }
}
