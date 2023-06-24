import java.io.File;
import java.io.FileInputStream;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        FileInputStream fStream = new FileInputStream(file);
        int byt = 0;
        while(true) {
            byt = fStream.read();
            if (byt == -1) break;
            System.out.printf("%02x ", byt);
        };
    }
}