import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class Driver extends Person{
    File DriverFile = new File("C:\\Users\\aaa\\oop-java\\final_3rdsem_java\\driver.txt");
    ArrayList<Driver> DriverList=new ArrayList<>();
    ListIterator li=null;

    ObjectOutputStream Driveroos=null;
    ObjectInputStream Driverois = null;

    private String driver_cnic;
    private String driver_license;


    Driver(){
        super();
        this.driver_cnic="";
        this.driver_license="";
    }

    Driver(String name, int age,String phone_no, String adress , String unique_id, String pass,
           String driver_cnic, String driver_license) {
        super(name, age,adress,phone_no,unique_id,pass);
        this.driver_cnic = driver_cnic;
        this.driver_license = driver_license;
    }

    void setDriver_cnic(String driver_cnic){
        this.driver_cnic=driver_cnic;
    }
    String getDriver_cnic(){
        return driver_cnic;
    }
    void setDriver_license(String driver_license){
        this.driver_license=driver_license;
    }
    String getDriver_license(){
        return driver_license;
    }

    @Override
    public String toString() {
        return
                "unique_id=" + getUnique_id() +
                        " driver_name=" + getName() +
                        " driver_age= " + getAge() +
                        " driver_cnic= " + driver_cnic +
                        "driver password = "+getPassword()+
                        " driver_license= " + driver_license;
    }
    boolean chek_driver_cnic(String driver_cnic){
        return driver_cnic.matches("\\d{13}");
    }
    boolean chek_license(String driver_license){
        return driver_license.matches("\\d{6}");
    }

    @Override
    void SignUp() {
        Scanner input=new Scanner(System.in);
        super.SignUp();
        System.out.println("enter driver cnic");
        this.driver_cnic=input.next();
        System.out.println("enter Driver license");
        this.driver_license=input.next();
        DriverList.add(new Driver(getName(),getAge(),getAdress(),getPhone_no(),
                getUnique_id(),getPassword(),driver_cnic,driver_license));
            try {
                Driveroos = new ObjectOutputStream(new FileOutputStream(DriverFile));
                Driveroos.writeObject(DriverList);
                System.out.println("done");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    @Override
    void Login() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your unique ID");
        String uniqId = input.next();
        System.out.println("enter your password");
        String password=input.next();
        {
            try {
                if (DriverFile.isFile()) {
                    Driverois = new ObjectInputStream(new FileInputStream(DriverFile));
                    DriverList = (ArrayList<Driver>) Driverois.readObject();
                    Driverois.close();
                    li = DriverList.listIterator();
                    while (li.hasNext()) {
                        Driver d = (Driver) li.next();
                        if (d.getUnique_id().equals(uniqId) && d.getPassword().equals(password)){
                            System.out.println("true");

                        }
                        else{
                            System.out.println("wrong ID or password");
                        }
                    }
                }
            }catch (IOException e){

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

