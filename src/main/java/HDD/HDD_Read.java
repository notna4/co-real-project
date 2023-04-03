package HDD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HDD_Read {
    String randomWord;
    static long timer=0;
    long startTimePerLine=0;
    long stopTimePerLine=0;
    long totalTime=0;

    public String Read() {
        try {
            File myObj = new File("Sample_HDD_Text.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myObj));
            String line= reader.readLine();
            //  System.out.println("Line is:"+line);
            List<String> words = new ArrayList<String>();

            while (line != null) {
                String[] wordsLine = line.split(" ");
                for (String word : wordsLine) {
                    words.add(word);
                }
                //startPerLine
                startTimePerLine=System.nanoTime();
                line = reader.readLine();
                stopTimePerLine=System.nanoTime();
                totalTime=stopTimePerLine-startTimePerLine;
                // stopPerLine;total+=stopPe..-startper...
                //  System.out.println("The lines are:"+line);
            }

            Random rand = new Random();
            randomWord = words.get(rand.nextInt(words.size()));
        }catch (FileNotFoundException a)
        {
            System.out.println("File does not exist!");
            a.printStackTrace();
        }
        catch (Exception e) {
            // Handle this
            System.out.println("Word cannot be read correctly!");
            e.printStackTrace();
        }
        System.out.println("The time of the sequential read is:"+totalTime+" nanoseconds");
        timer+=totalTime;
        return randomWord;
    }

    public long TotalTime()
    {
        return timer;
    }


}
