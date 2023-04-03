package HDD;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

class ProductFileStream {

    private PrintWriter writer;

    public ProductFileStream()  {
        try {
//            throw new FileNotFoundException(), new UnsupportedEncodingException();
//            writer = new PrintWriter("results.txt", "UTF-8");
            this.writer= new PrintWriter(new FileOutputStream("Sample_HDD_Text.txt", true /* append = true */));
        } catch (IOException err) {
            throw new RuntimeException(err);
        }
    }

    public void write(String a) {
        writer.println(a);
    }

    public void close() {
        writer.close();
    }
}

/*public class Write {
    public static void main(String[] args) {

        ProductFileStream pf=new ProductFileStream();
        pf.write("my inserted text");

        pf.close();

    }
}*/