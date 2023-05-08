package HDD;
import java.util.Scanner;



public class HDDBenchmarkV1
{
    public static void main(String[] args) {

        ProductFileStream pf=new ProductFileStream(true);
        pf.write("my inserted text");

        pf.close();

       // int iter=chooseIter();


    }

    public static void start(int iter) {
        HDD_Read xD=new HDD_Read();

        for(int i=0;i<iter;i++)
        {
            System.out.println("The selected word is:"+xD.Read());
        }
        System.out.println("The total sequential read time is:"+xD.TotalTime()+" nanoseconds");
    }

    public static int chooseIter()
    {
        System.out.println("Enter value:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
       // start(num);
        return num;
    }

}
