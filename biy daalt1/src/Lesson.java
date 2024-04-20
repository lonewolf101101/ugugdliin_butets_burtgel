public class Lesson
{
    public Subject learned;//Үзсэн хичээл
    public int score; //Шалгалтын оноо

    //builder functions
    public Lesson(Subject s,int sc)
    {
        this.learned = s;
        this.score = sc;
    }
    public Lesson()
    {
        this.learned = new Subject();
        this.score = 0;
    }

    //returns the gp grade of the score
    public float getPOINT() 
    {
        if(score >= 96)
            return 4.0f;
        else if (score >= 91 && score < 96)
            return 3.7f;
        else if (score >= 88 && score < 91)
            return 3.4f;
        else if (score >=84 && score < 88)
            return 3.0f;
        else if (score >=81 && score < 84)
            return 2.7f;
        else if (score >=78 && score < 81)
            return 2.4f;
        else if (score >=74 && score < 78)
            return 2.0f;
        else if (score >=71 && score < 74)
            return 1.7f;
        else if (score >=68 && score < 71)
            return 1.4f;
        else if (score >=64 && score < 68)
            return 1.0f;
        else if (score >=60 && score < 64)
            return 0.7f;
        else
            return 0.0f;
    }

    public void Displayhead()
    {
        String titletemplate = "%-20s %-40s %-10s %-5\n\n";
        System.out.println("-----------------------------SUBJECTS--------------------------------\n");
        System.out.printf(titletemplate,"Subject Code","Subject Name","Credits","GPA");
    }
    //prints the values
    public void DisplayLesson()
    {
        String titletemplate = "%-20s %-40s %7s %5f\n";
        System.out.printf(titletemplate, learned.getSubjectCode(), learned.getSubjectName(), learned.getCredit(), this.getPOINT());
    }
}