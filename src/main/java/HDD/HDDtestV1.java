package HDD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



class HDDtestV1
{
    public static void main(String[] args) {

        int iter=chooseIter();

        HDD xD=new HDD();

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
        return num;
    }

}
