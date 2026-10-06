import java.io.*;

class LowerCaseDecorator extends FilterReader {

    public LowerCaseDecorator(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int ch = super.read();

        if (ch == -1) {
            return -1;
        }

        return Character.toLowerCase((char) ch);
    }
}

public class Q1 {
    public static void main(String[] args) throws IOException {

        String text = "HELLO JAVA DESIGN PATTERN";

        Reader reader = new StringReader(text);

        Reader lowerReader = new LowerCaseDecorator(reader);

        int ch;

        while ((ch = lowerReader.read()) != -1) {
            System.out.print((char) ch);
        }

        System.out.println();
        lowerReader.close();
    }
}