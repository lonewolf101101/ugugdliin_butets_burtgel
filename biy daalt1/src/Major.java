public class Major // Мэргэжил
{
    private String majorCode;// код
    private String majorName;// нэр

    //builder functions
    public Major()
    {
        this.majorCode = null;
        this.majorName = null;
    }
    public Major(Major sub)
    {
        if (sub != null)
        {
            this.majorCode= sub.getMajorCode();
            this.majorName= sub.getMajorName(); 
        }
    }
    public Major(String ss)
    {
        String[] temp ;
        temp = ss.split("/");
        this.majorCode = temp[0];
        this.majorName = temp[1];
    }

    //getting ready for writing to major.txt file
    public String Writingstr()
    {
        String united;
        united = String.join("/", this.majorCode,this.majorName);
        return united;
    }


    //getting the values and setting functions;
    public String getMajorCode() {
        return majorCode;
    }
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    

    public void Displayhead()
    {
        String titletemplate = "%-20s %-40s \n";
        System.out.printf("\u001B[32m---------------MAJOR----------------\n\u001B[0m");
        System.out.printf(titletemplate,"Major code","Major name");
    
    }
    //prints the values
    public void DisplayMajor()
    {
        String titletemplate = "%-20s %-40s \n";
        System.out.printf(titletemplate,majorCode,majorName);
    }
}