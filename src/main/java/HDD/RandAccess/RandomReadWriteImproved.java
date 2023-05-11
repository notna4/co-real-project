package HDD.RandAccess;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomReadWriteImproved {
    public File file;

    private static final String FILE_NAME = "ScoreHistoryHDDRandom.txt";

    private String username;

    public RandomAccessFile raf;
    private String filePath;
    private long fileSize;
    private long TimeWrite,TimeRead1,TimeRead2;
    private double score;

    private long start_Total, stop_Total;
    private int MB = 0; //Desired size(in MB) of the file
    // Set the file path

    public void getUsername(String username)
    {
        this.username=username;
        System.out.println("The username is:" + username);
    }


    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public void setSize(int size) {

        fileSize = 1024 * 1024 * size;

    }


    public void setSize() {

        System.out.println("Select the file size(MB):");

        try {

            InputStreamReader inp = null;
            Scanner myscan = new Scanner(System.in);

            System.out.println();

            MB = myscan.nextInt();

            System.out.println("Size requested:" + MB);

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


    // Open the file for random access
    public void randomWrite() {
        long start = System.currentTimeMillis();

        try {
            raf = new RandomAccessFile(file, "rw");

            // Set the seed for the random number generator
            long seed = System.currentTimeMillis();
            Random random = new Random(seed);

            // Random write
            byte[] buffer = new byte[1024];
            for (long i = 0; i < fileSize; i += buffer.length) {
                random.nextBytes(buffer);
                raf.write(buffer);
            }
        } catch (IOException e) {
            System.out.println("Cannot write in the file!");
        }

        long stop = System.currentTimeMillis();
        System.out.println("Time elapsed for writing:" + (stop - start) + " milliseconds");

        TimeWrite=stop-start;
    }

    public void randomRead() {
        long start = System.currentTimeMillis();

        try {

            // Random read
            long seed = System.currentTimeMillis();
            Random random = new Random(seed);

            for (int i = 0; i < MB; i++) {
                byte[] buffer = new byte[1024];
                long position = random.nextInt((int) fileSize - buffer.length);
                raf.seek(position);
                raf.read(buffer);

            }
        } catch (IOException e) {
            System.out.println("Cannot read from the file!");
        }

        long stop = System.currentTimeMillis();
        System.out.println("Time elapsed for reading:" + (stop - start) + " milliseconds");
        TimeRead1=stop-start;
    }

    public void randomRead2()
    {

        long start = System.currentTimeMillis();

        try {

            Path path = Paths.get("Sample_HDD_Text_Dummy.txt");

            byte[] data = Files.readAllBytes(path);
        }catch(IOException e)
        {
            System.out.println("Error reading!");
        }

        long stop = System.currentTimeMillis();
        System.out.println("Time elapsed for reading:" + (stop - start) + " milliseconds");

        TimeRead2=stop-start;

    }

    public double getScore()
    {
//        score= ((double)(1/(TimeRead2*100/TimeRead1))*fileSize) +(int)TimeRead1; //Still WOIP - cristean: primesc exceptie cu "/ by zero" de fiecare data
        score = TimeRead2 + TimeRead1 + fileSize;
//        System.out.println("The score is:"+score);
        return score;
    }

    public void postScore(String nameText, int size)
    {

        try {
            FileWriter text = new FileWriter(FILE_NAME,true);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = now.format(formatter);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(nameText+ "," + formattedTime + "," + score+","+size+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
//            text.write(username+" : "+"score:"+score + "\n");
            text.close();
            System.out.println("Score posted!");
        } catch (IOException e) {
            System.out.println("Could not post score,error occured!");
            e.printStackTrace();
        }
    }



    // System.out.println("Total time elapsed:"+(stop2-start1) +" milliseconds");
    //closefile


    public void closeFile()
    {
        try{
            // Close the file
            raf.close();

            // Delete the file
            file.delete();

            System.out.println("Random read and write test completed successfully.");
        } catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
