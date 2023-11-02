package main;

import java.util.Scanner;
import manage.MyBST;
import menu.Menu;
import obj.Student;

public class Main {
    public static void main(String[] args) {
        MyBST bst = new MyBST();
        Scanner scanner = new Scanner(System.in);
        
        Menu menu = new Menu("Student Management-----");
        menu.addNewOption("                 1. Add");
        menu.addNewOption("                 2. Delete");
        menu.addNewOption("                 3. Correct point");
        menu.addNewOption("                 4. Update phone");
        menu.addNewOption("                 5. Print");
        menu.addNewOption("                 6. Quit");
        
        int choice = 0;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1: 
                    System.out.println("Nhập thông tin sinh viên");
                    
                    String stdid = util.Validation.getRegexString("Nhập mã sinh viên: ", "Sai cú pháp! Ví dụ: S001,...", "^[S|s]\\d{3}$");
                    
                    String name = util.Validation.getString("Nhập tên sinh viên: ", "Tất cả các ô không được bỏ trống!");
                    
                    int yearOfBirth = util.Validation.getAnInteger("Nhập năm sinh: ", "Tất cả các ô không được bỏ trống và điền bằng chữ số", 0);
                    
                    double gpa = util.Validation.getADouble("Nhập gpa: ", "Tất cả các ô không được bỏ trống và điền bằng chữ số", 0);
                    
                    String phoneNumber = util.Validation.getRegexString("Nhập số điện thoại: ", "Sai cú pháp!. Ví dụ: 0xxxxxxxxx", "0\\d{9}");
                    
                    Student student = new Student(stdid, name, yearOfBirth, gpa, phoneNumber);
                    bst.addStudent(student);
                    
                    System.out.println("Sinh viên đã được thêm thành công!");
                    break;
                case 2:
                    String stdidToDelete = util.Validation.getRegexString("Nhập mã của sinh viên cần xóa: ", "Sai cú pháp! Ví dụ: S001,...", "^[S|s]\\d{3}$");
                    bst.deleteStudent(stdidToDelete);
                    
                    System.out.println("Sinh viên đã được xóa thành công!");
                    break;
                case 3:
                    String stdidToEditGpa = util.Validation.getRegexString("Nhập mã sinh viên của sinh viên cần sửa điểm trung bình: ", "Sai cú pháp! Ví dụ: S001,...", "^[S|s]\\d{3}$");
                    
                    double newGpa = util.Validation.getADouble("Nhập điểm trung bình mới: ", "Tất cả các ô không được bỏ trống và điền bằng chữ số", 0);
                    bst.updateGpa(stdidToEditGpa, newGpa);
                    
                    System.out.println("Điểm trung bình đã được cập nhật thành công!");
                    break;
                case 4:
                    String stdidToEditPhoneNumber = util.Validation.getRegexString("Nhập mã sinh viên của sinh viên cần cập nhật số điện thoại: ", "Sai cú pháp! Ví dụ: S001,...", "^[S|s]\\d{3}$");
                    
                    String newPhoneNumber = util.Validation.getRegexString("Nhập số điện thoại mới: ", "Sai cú pháp!. Ví dụ: 0xxxxxxxxx", "0\\d{9}");
                    bst.updatePhoneNumber(stdidToEditPhoneNumber, newPhoneNumber);
                    
                    System.out.println("Số điện thoại đã được cập nhật thành công!");
                    break;
                case 5:
                    System.out.println("Danh sách sinh viên:");
                    bst.printStudents();
                    break;
                case 6:
                    System.out.println("Đang thoát chương trình...");
                    break;
            }
        } while (choice != 6);
    }
}
