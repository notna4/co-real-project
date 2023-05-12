package HDD.RandAccess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RandomReadWriteMain {

    public double startRandomReadWrite(String nameText, int size, String category) {
        //i use this method in javafx - cristean
        RandomReadWriteImproved bench =new RandomReadWriteImproved();

        String filePath = "Sample_HDD_Text_Dummy.txt";

        bench.setFilePath(filePath);
        bench.setSize(size);
        bench.createFile();
        bench.randomWrite();
        bench.randomRead();
        bench.randomRead2();
        bench.getScore();
        bench.postScore(nameText, size, category);
        bench.closeFile();

        return bench.getScore();
    }
    public static void main(String[] args) {
        RandomReadWriteImproved bench =new RandomReadWriteImproved();

        String username;

        System.out.println("insert username:");

        try {

            // InputStreamReader inp = null;
            Scanner myscan = new Scanner(System.in);

            System.out.println();

            username = myscan.nextLine();


            bench.getUsername(username);

        } catch (
                InputMismatchException e) {
            System.out.println("Invalid value!");
        }

        String filePath = "Sample_HDD_Text_Dummy.txt";

//        bench.setFilePath(filePath);
//        bench.setSize();
//        bench.createFile();
//        bench.randomWrite();
//        bench.randomRead();
//        bench.randomRead2();
//        bench.getScore();
//        bench.postScore();
//        bench.closeFile();

    }
}
