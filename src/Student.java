import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class Student extends Person {
    private String gender;
    private int student_class;
    private String emergency_contact;
    Scanner input = new Scanner(System.in);
    File StudentFile = new File("C:\\Users\\aaa\\oop-java\\final_3rdsem_java\\Student.txt");
    ArrayList<Student> StudentList = new ArrayList<>();
    ListIterator li = null;

    ObjectOutputStream Studentoos = null;
    ObjectInputStream Studentois = null;


    Student() {
        super();
        this.gender = "";
        this.student_class = 0;
        this.emergency_contact = "";
    }


    Student(String name, int age, String phone_no, String adress, String unique_id, String pass,
            String gender, int student_class, String emergency_contact) {
        super(name, age, adress, phone_no, unique_id, pass);

        this.gender = gender;
        this.student_class = student_class;
        this.emergency_contact = emergency_contact;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    String getGender() {
        return gender;
    }

    void setStudent_class(int student_class) {
        this.student_class = student_class;
    }

    int getStudent_class() {
        return student_class;
    }

    void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    String getEmergency_contact() {
        return emergency_contact;
    }

    @Override
    public String toString() {
        return
                "unique_id=" + getUnique_id() +
                        " student_name= " + getName() +
                        " Student age = " + getAge() +
                        "Student Gender = "+ getGender()+
                        " student class= " + student_class +
                        " student adress = " + getAdress() +
                        "student emergency contact number =" + emergency_contact;

    }


    @Override
    void SignUp() {
        super.SignUp();
        System.out.println("Enter student class:");
        this.student_class = input.nextInt();
        System.out.println("Enter student emergency contact number");
        this.emergency_contact = input.next();
        System.out.println("Enter Student Gender");
        this.gender=input.next();
        StudentList.add(new Student(getName(), getAge(), getAdress(), getPhone_no(),
                getUnique_id(), getPassword(), gender , student_class, emergency_contact));
        {
            try {
                Studentoos = new ObjectOutputStream(new FileOutputStream(StudentFile));
                Studentoos.writeObject(StudentList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    void Login() {
        System.out.println("Enter your unique ID");
        String uniqId = input.next();
        System.out.println("enter your password");
        String password = input.next();
        {
            try {
                if (StudentFile.isFile()) {
                    Studentois = new ObjectInputStream(new FileInputStream(StudentFile));
                    StudentList = (ArrayList<Student>) Studentois.readObject();
                    Studentois.close();
                    li = StudentList.listIterator();
                    while (li.hasNext()) {
                        Student s = (Student) li.next();
                        if (s.getUnique_id().equals(uniqId) && s.getPassword().equals(password)) {
                            System.out.println("true");

                        }
                    }
                }
            } catch (IOException e) {

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

