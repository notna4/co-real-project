package HDD;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SeqWriteMain {

    public double start(int size) {
        SeqWriteBench bench = new SeqWriteBench();
        String filePath = "SeqWriteFile.txt";
        bench.setFilePath(filePath);
        bench.setSize(size);
        bench.createFile();
//        bench.warmup();
        bench.seqWrite();
        double score = bench.getScore();
//        bench.postScore();
        bench.closeFile();

        return score;
    }


    public static void main(String[] args) {
        SeqWriteBench bench = new SeqWriteBench();

        String username;
        System.out.println("Enter username:");

        try
        {
            Scanner scan = new Scanner(System.in);
            //System.out.println();
            username = scan.nextLine();
            bench.setUsername(username);
        } catch (
                InputMismatchException e) {
            System.out.println("Invalid value!");
        }

        String filePath = "SeqWriteFile.txt";

//        bench.setFilePath(filePath);
//        bench.setSize();
//        bench.createFile();
//        bench.warmup();
//        bench.seqWrite();
//        bench.getScore();
//        bench.postScore();
//        bench.closeFile();
    }
}
