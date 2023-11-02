package obj;

public class Student implements Comparable<Student> { 
    private String stdID;
    private String name;
    private int yearOfBirth;
    private double gpa;
    private String phoneNumber;

    public Student(String stdID, String name, int yearOfBirth, double gpa, String phoneNumber) {
        this.stdID = stdID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
        this.phoneNumber = phoneNumber;
    }

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Student st) {
        return this.stdID.compareTo(st.stdID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdID = '" + stdID + '\'' +
               ", name = '" + name + '\'' +
        ", yearOfBirth = " + yearOfBirth +
                ", gpa = " + gpa +
        ", phoneNumber = '" + phoneNumber + '\'' +
                      '}';
    }
}
