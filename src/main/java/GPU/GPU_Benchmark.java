package GPU;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GPU_Benchmark {
    /**
     * Function used to run the GPU benchmark, by running a python script that outputs 2 photos, the score and the times of the benchmarks.
     * @param choice What type of the benchmark you want, given as a string:
     *               1-easy,
     *               2-normal,
     *               3-hard.
     */
    public void gpuBench(String choice)
    {
        try {
            //used to run a python executable
            ProcessBuilder pb = new ProcessBuilder("./piton", choice);
            pb.directory(new File(System.getProperty("user.dir")));

            Process process = pb.start();

            //this takes what the shell is outputting and storing it in output for later printing
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            //if the process is finished, then print to the screen
            int exitVal = process.waitFor();

            //comment these lines if you dont want to print to the screen
            if (exitVal == 0) {
                System.out.println("**************************** The Output is ******************************");
                System.out.println(output);
//                System.exit(0);
            }
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Your operating system is not supported!");
            System.out.println("Any linux distro is supported.");
        }
    }
    /*
    public static void main(String[] args){
        GPU_Benchmark benchmark = new GPU_Benchmark();
        benchmark.gpuBench("1");
    }
    */
}
