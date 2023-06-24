import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class App {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("dumpfile.bin");
        byte byte1 = 0, byte2 = 0, byte3 = 0, byte4 = 0;
        int fileNumber = 0;
        FileOutputStream fileOutput = null;
        while (file.available() > 0) {
            byte1 = byte2;
            byte2 = byte3;
            byte3 = byte4;
            byte4 = (byte) file.read();
            if (byte1 == 0x25 && byte2 == 0x50 && byte3 == 0x44 && byte4 == 0x46 && fileOutput == null) {
                fileOutput = new FileOutputStream((++fileNumber) + ".pdf");
                fileOutput.write(byte1);
                fileOutput.write(byte2);
                fileOutput.write(byte3);
                fileOutput.write(byte4);
            } else if (fileOutput != null) {
                fileOutput.write(byte4);
                if (byte1 == 0x25 && byte2 == 0x25 && byte3 == 0x45 && byte4 == 0x4F) {
                    fileOutput.close();
                    fileOutput = null;
                }
            }
        }
        file.close();
    }
}