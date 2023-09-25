import javax.security.auth.login.LoginContext;
import java.io.Serializable;
import java.util.Scanner;

class Person implements Serializable {
    private String name;
    private int age;
    private String adress;
    private String phone_no;
    private String unique_id;
    private String password;

    Person() {
        name = "";
        age = 0;
        adress = "";
        phone_no = "";
        unique_id = "";
        password = "";

    }

    Person(String name, int age, String adress, String phone_no, String unique_id, String password) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.phone_no = phone_no;
        this.unique_id = unique_id;
        this.password = password;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void setAdress(String adress) {
        this.adress = adress;
    }

    String getAdress() {
        return adress;
    }

    void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    String getPhone_no() {
        return phone_no;
    }

    void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    String getUnique_id() {
        return unique_id;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getPassword() {
        return password;
    }

    public String toString() {
        return
                "Name = " + name +
                        "Age = " + age +
                        "Adress = " + adress +
                        "Phone no = " + phone_no +
                        "Unique id = " + unique_id +
                        "password = " + password;


    }




    public static boolean isValidAddress(String address) {
        if (address == null || address.trim().isEmpty())
            return false;
        return true;
    }

    void SignUp(){
        Scanner input= new Scanner(System.in);
        System.out.println("enter your name");
        this.name=input.next();
        System.out.println("enter your age");
        this.age=input.nextInt();
        System.out.println("enter your adress");
        this.adress=input.next();
        System.out.println("enter your phone number");
        this.phone_no=input.next();
        System.out.println("enter your unique id");
        this.unique_id=input.next();
        System.out.println("enter your 8 DIGIT password");
        this.password=input.next();
    }
    void Login(){

    }
}


