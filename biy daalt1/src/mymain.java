import java.util.*;


public class mymain
{
    public static void main(String[] args)
    {
        Registration reg = new Registration();
        Scanner sc = new Scanner(System.in);
        Major maj = new Major();
        String temparary, temp;
        int flag = 0, choice, subject, student, grade;

        //reads datat from their prespective files
        reg.readStudentlist();
        
        while (flag == 0)
        {
            System.out.println("1. Add student\n2. Add lesson grade to student\n3. Remove failed student\n4. Sort student by Major\n5. Sort student by subject\n6. Show every student's GPA\n7.Quit");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("please enter you student code:");
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    reg.PrintMajor();
                    System.out.print("please enter your Major(note:please write the code of the major specific):");
                    temparary = sc.nextLine();
                    maj = reg.getMajor(temparary);
                    if (maj == null) 
                        System.out.println("Invalid major code. Please enter a valid major code.");
                        // You might want to loop back to the major input or handle it based on your application logic.
                    else 
                        reg.addStudent(temp, maj);
                    break;


                case 2:
                    reg.PrintStudentGPA();
                    System.out.println("\n\nplease choose the student:");
                    student = sc.nextInt() - 1;
                    reg.PrintSubject();
                    System.out.print("\n\nplease choose your subject:");
                    subject = sc.nextInt() - 1;
                    System.out.print("\n\nplease enter your grade:");
                    grade = sc.nextInt();
                    if(grade <= 100 && 0 <= grade)
                        ((Student)reg.studentlist.get(student)).addLesson((Subject)reg.subjectlist.get(subject), grade);
                    else
                        System.out.println("this is not a gradeable grade try again");
                    
                    break;


                case 3:
                    reg.Failures();
                    reg.PrintFailureGPA();
                    System.out.println("please choose the student who will be expelled");
                    if(reg.failurelist.size() != 0)
                    {
                        student = sc.nextInt() - 1;
                        if(reg.failurelist.size() > student)
                            reg.deletefailure(student);
                        else
                            System.out.println("this student is not in the failure list");
                    }
                    break;


                case 4:
                    reg.PrintbyMajor();
                    break;


                case 5:
                    reg.PrintbySubject();
                    break;


                case 6:
                    reg.PrintStudentGPA();
                    break;


                case 7:
                    reg.writeStudentlist();
                    reg.writeMajorList();
                    reg.writeSubjectlist();
                    flag = 1;
                    break;


                default:
                    System.out.println("It is note the right action choose again");
                    break;
            }
        }
    }
}