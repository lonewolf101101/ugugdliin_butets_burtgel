public class Subject // Хичээл
{
    private String subjectCode;// код
    private String subjectName;// нэр
    private float credit;// кредит

    //builder functions
    public Subject()
    {
        subjectCode = null;
        subjectName = null;
        credit = 0.0f;
    }
    public Subject(Subject sub)
    {
        if(sub != null)
        {
        this.subjectCode = sub.getSubjectCode();
        this.subjectName = sub.getSubjectName();
        this.credit = sub.getCredit();
        }
    }
    public Subject(String ss) 
    {
        String[] temp;
        temp = ss.split("/");
        this.subjectCode = temp[0];
        this.subjectName = temp[1];
        this.credit = Float.parseFloat(temp[2]);
    }

    //getting ready for writing to major.exe file
    public String Writingstr()
    {
        String united;
        united = String.join("/", this.subjectCode,this.subjectName,Float.toString(this.credit));
        return united;
    } 



    
    //getting the value and setting functions;
    public String getSubjectCode() {
        return subjectCode;
    }
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getCredit() {
        return credit;
    }
    public void setCredit(float credit) {
        this.credit = credit;
    }

    
    public void Displayhead()
    {
        String titletemplate = "    %-20s %-40s %-10s\n\n";
        System.out.println("\u001B[34m---------------------------------SUBJECTS--------------------------------\n\u001B[0m");
        System.out.printf(titletemplate,"Subject Code","Subject Name","Credits");
    }
    //prints the values
    public void DisplaySubject()
    {
        String titletemplate = "%-20s %-40s %7s\n";
        System.out.printf(titletemplate, subjectCode,subjectName,credit);
    }
}