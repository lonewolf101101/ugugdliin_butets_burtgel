import javax.management.MalformedObjectNameException;
import dataStructures.*;

import dataStructures.*;
public class Student // Оюутан
{
    private String studentCode;// код
    private float GPA;// голч дүн
    private Major studentMajor;//мэргэжил
    public Chain lessons;// үзсэн хичээлүүд
    public ArrayLinearList writes;
    //builder functions
    public Student()
    {
        studentCode = null;
        studentMajor = null;
        lessons = null;
        
    }
    public Student(String sCode, Major smajor)
    {
        studentCode = sCode;
        studentMajor = new Major(smajor);
        lessons = new Chain();
    }

    

    //getting ready for writing to exam.txt file
    public ArrayLinearList WritingStr()
    {
        writes = new ArrayLinearList();
        String temp;
        for(int i = 0; i < lessons.size(); i++)
        {
            temp = String.join("/", studentMajor.getMajorCode(), studentCode, ((Lesson)this.lessons.get(i)).learned.getSubjectCode(), Integer.toString(((Lesson)this.lessons.get(i)).score));
            writes.add(writes.size(),temp);
        }
        return writes;
    }
    
    public String getCode()
    {
        return studentCode;
    }
    public void setCode(String code)
    {
        this.studentCode = code;
    }
    
    public float getGPA()
    {
        float sumcr = 0, sumch = 0;
        for(int i = 0; i < lessons.size(); i++)
        {
            sumcr += ((Lesson)lessons.get(i)).learned.getCredit();
            sumch += ((Lesson)lessons.get(i)).learned.getCredit()*((Lesson)lessons.get(i)).getPOINT();
        }
        if(sumcr != 0)
            GPA = sumch/sumcr;
        return GPA;
    }
    
    public Major getMajor()
    {
        return (Major)studentMajor;
    }
    
    public void setMajor(Major mj)
    {
        this.studentMajor=mj;
    }


    public void Displaylessons()
    {
        ((Lesson)lessons.get(0)).Displayhead();
        for(int i = 0; i < lessons.size(); i++)
        {
            ((Lesson)lessons.get(i)).DisplayLesson();
        }
    }
    
    public void addLesson(Subject l,int sc)
    {
        Lesson al = new Lesson(l,sc);
        if(lessons.indexOf(al) == -1)
            lessons.add(lessons.size(), al);    
    }
    
    public Lesson removeLesson(Lesson l)
    {
        try{
            int index = lessons.indexOf(l);
            if(index == -1)
            throw new Exception("The lesson is not in the list");
            else
            return (Lesson)lessons.remove(index);
        }catch (Exception e)
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
    



    public void Displayhead()
    {
        String titletemplate = "    %-20s %10s %10s\n\n";
        System.out.println("\u001B[33m-------------------Students GPA-------------------\n\u001B[0m");
        System.out.printf(titletemplate,"Student Code","Lesson's count","GPA");
    }
    public void DisplayStudent()
    {
        String titletemplate = "%-20s %14s %10.2f\n";
        System.out.printf(titletemplate, this.studentCode, this.lessons.size() ,this.getGPA());
    }
}