package manage;

import obj.Student;

public class MyBST {
    private Node root;

    private class Node {
        private Student student;
        private Node left;
        private Node right;

        public Node(Student student) {
            this.student = student;
            left = null;
            right = null;
        }
    }

    public void addStudent(Student student) {
        root = addStudentRec(root, student);
    }

    private Node addStudentRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        if (student.compareTo(root.student) < 0) {
            root.left = addStudentRec(root.left, student);
        } else if (student.compareTo(root.student) > 0) {
            root.right = addStudentRec(root.right, student);
        }

        return root;
    }

    public void deleteStudent(String stdid) {
        root = deleteStudentRec(root, stdid);
    }

    private Node deleteStudentRec(Node root, String stdid) {
        if (root == null) {
            return root;
        }

        if (stdid.compareTo(root.student.getStdID()) < 0) {
            root.left = deleteStudentRec(root.left, stdid);
        } else if (stdid.compareTo(root.student.getStdID()) > 0) {
            root.right = deleteStudentRec(root.right, stdid);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.student = minValue(root.right);

            root.right = deleteStudentRec(root.right, root.student.getStdID());
        }

        return root;
    }

    private Student minValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.student;
    }

    public void updateGpa(String stdid, double gpa) {
        updateGpaRec(root, stdid, gpa);
    }

    private void updateGpaRec(Node root, String stdid, double gpa) {
        if (root == null) {
            return;
        }

        if (stdid.compareTo(root.student.getStdID()) < 0) {
            updateGpaRec(root.left, stdid, gpa);
        } else if (stdid.compareTo(root.student.getStdID()) > 0) {
            updateGpaRec(root.right, stdid, gpa);
        } else {
            root.student.setGpa(gpa);
        }
    }

    public void updatePhoneNumber(String stdid, String phoneNumber) {
        updatePhoneNumberRec(root, stdid, phoneNumber);
    }

    private void updatePhoneNumberRec(Node root, String stdid, String phoneNumber) {
        if (root == null) {
            return;
        }

        if (stdid.compareTo(root.student.getStdID()) < 0) {
            updatePhoneNumberRec(root.left, stdid, phoneNumber);
        } else if (stdid.compareTo(root.student.getStdID()) > 0) {
            updatePhoneNumberRec(root.right, stdid, phoneNumber);
        } else {
            root.student.setPhoneNumber(phoneNumber);
        }
    }

    public void printStudents() {
        printStudentsRec(root);
    }

    private void printStudentsRec(Node root) {
        if (root != null) {
            printStudentsRec(root.left);
            System.out.println(root.student.toString());
            printStudentsRec(root.right);
        }
    }
}
