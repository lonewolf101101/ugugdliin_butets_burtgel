import dataStructures.ArrayLinearList;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Registration 
{
    public ArrayLinearList subjectlist;
    public ArrayLinearList studentlist;
    public ArrayLinearList majorlist;
    public ArrayLinearList failurelist;

    //constructor for the registration object
    public Registration() 
    {
        this.subjectlist = new ArrayLinearList();
        this.studentlist = new ArrayLinearList();
        this.majorlist = new ArrayLinearList();
        this.failurelist = new ArrayLinearList();
    }
    




    

    //methods for SUBJECT CLASS
    //read and write subject
    public void readSubjectlist()
    {
        try 
        {
            File file = new File("subject.txt");
            Scanner sc = new Scanner(file);
            int k = 0;
            while (sc.hasNextLine()) 
            {
                Subject subject = new Subject(sc.nextLine());
                this.subjectlist.add(k,subject);
                k++;                
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error: File not found");
            System.exit(0);
        }   
    }

    public void writeSubjectlist()
    {
        try 
        {
            FileWriter file = new FileWriter("subject.txt");
            for(int i = 0; i < this.subjectlist.size(); i++) 
            {
                file.write(((Subject)this.subjectlist.get(i)).Writingstr()+"\n");
            }
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: File not found");
            System.exit(0);
        }   
    }
    
    public void PrintSubject()
    {
        ((Subject)this.subjectlist.get(0)).Displayhead();
        for(int i = 0; i < this.subjectlist.size(); i++)
        {
            System.out.printf("%2d  ",i+1);
            ((Subject)this.subjectlist.get(i)).DisplaySubject();
        }
    }

    public int getSubject(String sb)
    {
        int ind = -1;
        for(int i = 0; i < this.subjectlist.size(); i++)
            if(((Subject)this.subjectlist.get(i)).getSubjectCode().equals(sb))
                ind = i;
        
        return ind;
    }
    






    //methods for MAJOR CLASS
    //read and write for majorlist
    public void readMajorList()
    {
        try 
        {
            File file = new File("major.txt");
            Scanner sc = new Scanner(file);
            int k=0;
            while (sc.hasNextLine()) 
            {
                Major mc = new Major(sc.nextLine());
                this.majorlist.add(k,mc);
                k++;
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error: File not found");
            System.exit(0);
        }
    }

    public void writeMajorList()
    {
        try 
        {
            FileWriter file = new FileWriter("major.txt");
            for(int i = 0 ; i < majorlist.size(); i++)
            {
                file.write(((Major)this.majorlist.get(i)).Writingstr()+"\n");
            }
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("Error writing to file");
            System.exit(0);
        }
        
    }

    public void PrintMajor()
    {
        ((Major)this.majorlist.get(0)).Displayhead();
        for(int i = 0; i < this.majorlist.size(); i++)
            ((Major)this.majorlist.get(i)).DisplayMajor();
    }

    public Major getMajor(String mc)
    {
        Major major = new Major();
        Major major1 = new Major();
        for(int i = 0; i < this.majorlist.size(); i++)
        {
            major = ((Major)this.majorlist.get(i));
            if(major.getMajorCode().equals(mc))
                major1 = major;
        }
        return major1;
    }
    







    //methods for STUDENT CLASS
    public int checkStudent(String sc)
    {
        int flag = -1;
        for(int i = 0; i < this.studentlist.size(); i++)
        {
            if(((Student)this.studentlist.get(i)).getCode().equals(sc))
            {
                flag = i;
                break;
            }
        }
        return flag;
    }
    
    public void readStudentlist()
    {
        try
        {
            this.readMajorList();
            this.readSubjectlist();
            File file = new File("exam.txt");
            Scanner sc = new Scanner(file);
            int k = 0;
            while(sc.hasNextLine())
            {
                String temp = sc.nextLine();
                String [] arr =temp.split("/");
                if(checkStudent(arr[1]) == -1)
                {
                    Student student = new Student(arr[1] , (Major)this.getMajor(arr[0]));
                    if(this.getSubject(arr[2]) != -1)
                        student.addLesson((Subject) this.subjectlist.get(this.getSubject(arr[2])), Integer.parseInt(arr[3].trim()));;
                    studentlist.add(k++,student);
                }
                else
                {
                    ((Student)this.studentlist.get(checkStudent(arr[1]))).addLesson((Subject)this.subjectlist.get(this.getSubject(arr[2])), Integer.parseInt(arr[3]));
                }
            }   
        }
        catch(IOException ioe)
        {
            System.out.println("Error: File not found");
            System.exit(0);
        }
    }

    public void writeStudentlist()
    {
        try
        {
            FileWriter file = new FileWriter("exam.txt");
            ArrayLinearList writes = new ArrayLinearList();
            for(int i=0 ; i<this.studentlist.size(); i++)
            {
                ArrayLinearList temp = ((Student)studentlist.get(i)).WritingStr();
                for(int j = 0; j < temp.size(); j++)
			        writes.add(writes.size(),  temp.get(j));
            }
            for(int i = 0; i < writes.size(); i++)
                file.write((String)writes.get(i)+"\n");
            file.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error: File not found");
            System.exit(1);
        }
    }

    public void addStudent(String code, Major major)
    {
        Student temp = new Student(code,major);
        if(checkStudent(code) == -1)
            this.studentlist.add(this.studentlist.size(),temp);
        else
            System.out.println("this student already exists");
    }




    //every possible printing options
    public void PrintStudentGPA()
    {
        Student temp = new Student();
        temp.Displayhead();
        for (int i = 0; i < studentlist.size(); i++)
        {
            System.out.printf("%2d  ",i+1);
            ((Student)this.studentlist.get(i)).DisplayStudent();
        }
    }

    public void PrintbyMajor()
    {
        Student temp = new Student();
        for (int i = 0; i < majorlist.size(); i++)
        {
            int flag = 0;
            String ana = ((Major)majorlist.get(i)).getMajorCode();
            for(int j = 0; j < studentlist.size(); j++)
            {
                Major temparary = new Major((Major)
                ((Student)this.studentlist.get(j)).getMajor());
                String anal = temparary.getMajorCode();
                if(ana == anal)
                {  
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
            {
                System.out.println("\n\u001B[32m");
                ((Major)this.majorlist.get(i)).DisplayMajor();
                System.out.println("\u001B[0m");
                temp.Displayhead();
            }
            for(int j = 0; j < studentlist.size(); j++)
            {
                Major temparary = new Major((Major)
                ((Student)this.studentlist.get(j)).getMajor());
                String anal = temparary.getMajorCode();
                if(ana == anal)  
                    ((Student)studentlist.get(j)).DisplayStudent();
            }
        }
    }

    public void PrintbySubject()
    {
        Subject temp = new Subject();
        for (int i = 0; i < subjectlist.size(); i++)
        {
            for(int j = 0; j < studentlist.size(); j++)
            {
                int flag = 0, k = 0;
                Student temparary = (Student)this.studentlist.get(j);
                while(k < temparary.lessons.size())
                {
                    if(((Subject)((Lesson)temparary.lessons.get(k)).learned).equals((Subject)subjectlist.get(i)))
                        flag = 1;
                    k++;
                }
                if (flag == 1)
                {
                    System.out.println("\n\u001B[32m");
                    ((Subject)this.subjectlist.get(i)).DisplaySubject();
                    System.out.println("\u001B[0m");
                    ((Student)this.studentlist.get(0)).Displayhead();
                    break;
                }
            }

            for(int j = 0; j < studentlist.size(); j++)
            {
                int flag = 0, k = 0;
                Student temparary = (Student)this.studentlist.get(j);
                while(k < temparary.lessons.size())
                {
                    if(((Subject)((Lesson)temparary.lessons.get(k)).learned).equals((Subject)subjectlist.get(i)))
                        flag = 1;
                    k++;
                }
                if (flag == 1)
                    ((Student)studentlist.get(j)).DisplayStudent();
            }
        }
    }
    
    


    public void deletefailure(int a)
    {
        String code;
        code = ((Student)failurelist.get(a)).getCode();
        int coder = checkStudent(code);
        studentlist.remove(coder);
    }

    //prints failure of a human beings informaton
    public void PrintFailureGPA()
    {
        Student temp = new Student();
        if(failurelist.size() != 0)
        {
            System.out.println("\u001B[31mThe Students who have failed more than 3 three time\n\u001B[0m");
            temp.Displayhead();
        }
        else
            System.out.println("There isn't anybody close to expelling");
        for (int i = 0; i < failurelist.size(); i++)
        {
            System.out.printf("%2d  \u001B[35m",i+1);
            ((Student)this.failurelist.get(i)).DisplayStudent();
        }
        System.out.print("\u001B[0m");
    }
    
    //finds failed student finders
    public void Failures()
    {
        Student temp = new Student();
        for(int i = 0; i < studentlist.size(); i++)
        {
            int failed = 0, k = 0;
            temp = (Student)this.studentlist.get(i);
            while(k < temp.lessons.size())
            {
                if(((Lesson)temp.lessons.get(k)).getPOINT() < 0.7f)
                    failed++;
                k++;
            }
            if(failed >= 3) failurelist.add(failurelist.size(),temp);
        }
    }
}