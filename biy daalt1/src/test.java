public class test
{
    public static void main(String[] args)
    {
        String [] ant = new String[10];
        ant[0] = "45";
        ant[1] = "asdf";
        ant[2] = "asdf";
        ant[3] = "asdf";
        ant[4] = "asdf";
        ant[5] = "asdf";
        int a = 15;
        String temp;
        temp = String.join("/",ant[0] ,ant[1], ant[2],Float.toString(a));
        System.out.println("ant: "+temp);
    }
}