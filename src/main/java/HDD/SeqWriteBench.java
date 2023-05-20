package HDD;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SeqWriteBench {

    private String username, filePath;
    private int MB = 0;
    private double score;
    private long fileSize, writeTime;
    public File file;

    public void setUsername(String username)
    {
        this.username=username;
        System.out.println("username is: "+ this.username);
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public void setSize() {

        System.out.println("Select the file size(MB):");

        try {

            InputStreamReader inp = null;
            Scanner myscan = new Scanner(System.in);

            System.out.println();

            MB = myscan.nextInt();

            System.out.println("Size requested: " + MB);

        } catch (
                InputMismatchException e) {
            System.out.println("Invalid value!");
        }

        fileSize = 1024 * 1024 * MB;
    }

    public void createFile() {

        try {
            file = new File(filePath);
            // Create the file
            file.createNewFile();
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists!");
        } catch (Exception e) {
            System.out.println("Exception encountered!");
        }
    }

    public void warmup()
    {
        try {

            File file = new File("warmup.txt");
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            Random random = new Random();
            long start, stop;
            for(int buffer=2; buffer<=4096;buffer*=2)
            {
                start=System.currentTimeMillis();
                for (int i = 0; i < fileSize; i++)
                {
                    char[] word = new char[buffer];
                    i += word.length - 1;
                    for (int j = 0; j < word.length; j++) {
                        word[j] = (char) ('a' + random.nextInt(26));
                    }
                    writer.print(new String(word) + ' ');
                    i++;
                }
                stop = System.currentTimeMillis();
                System.out.println("WARMUP: Time elapsed for writing with buffer of " + buffer + " bytes is: " + (stop - start) + " milliseconds");
                //System.out.println("warmup buffer: "+ buffer);
            }
            writer.close();
            file.delete();
            System.out.println("Warmed up on a " + fileSize/1024/1024 + " MB file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seqWrite()
    {
        long start;// = System.currentTimeMillis();
        long stop; // = System.currentTimeMillis();
        long[] results = new long[12];
        int index=0;
        try{

            File file = new File(filePath);
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            Random random = new Random();

            for(int buffer=2; buffer<=4096;buffer*=2)
            {
                start=System.currentTimeMillis();
                for (int i = 0; i < fileSize; i++)
                {
                    char[] word = new char[buffer];
                    i += word.length - 1;
                    for (int j = 0; j < word.length; j++) {
                        word[j] = (char) ('a' + random.nextInt(26));
                    }
                    writer.print(new String(word) + ' ');
                    i++;
                }
                stop = System.currentTimeMillis();
                System.out.println("Time elapsed for writing with buffer of " + buffer + " bytes is: " + (stop - start) + " milliseconds");
                results[index]=stop-start;
                index++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long sum=0;
        for(int i=0;i<results.length;i++)
        {
            sum+=results[i];
        }
        writeTime=sum/results.length;
    }

    public void getScore()
    {
        //score= ((double)(1/(TimeRead2*100/TimeRead1))*fileSize) +(int)TimeRead1; //Laoo formula
        score = (double) ((fileSize/1024*1024)/((double)writeTime/1000000000.0));
        System.out.println("The score is: "+score);
    }

    public void postScore()
    {
        try {
            FileWriter text = new FileWriter("SeqWriteScoreHistory.txt",true);
            text.write(username + " : score: "+score + "\n");
            text.close();
            System.out.println("Score posted!");
        } catch (IOException e) {
            System.out.println("Could not post score, error occured!");
            e.printStackTrace();
        }
    }

    public void closeFile()
    {
        try{
            // Delete the file
            //file.delete();

            System.out.println("Sequential write test completed successfully.");
        } catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
