package etc.one;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPipes {
  public static void writeData(OutputStream os) {
    try {
      DataOutputStream out = new DataOutputStream(new BufferedOutputStream(os));

      int[] numArray = { 1, 2, 3, 4, 5 };

      for (int i = 0; i < numArray.length; i++) {
        out.writeInt(numArray[i]);
      }

      out.flush();

      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void readData(InputStream is) {
    DataInputStream in = new DataInputStream(new BufferedInputStream(is));
    boolean eof = false;
    try {
      while (!eof) {
          int iValue = in.readInt();
          System.out.println("read value = " + iValue);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("End of Data");
  }

  public static void main(String[] args) throws Exception {
    final PipedOutputStream pos = new PipedOutputStream();

    final PipedInputStream pis = new PipedInputStream(pos);

    Runnable runOutput = new Runnable() {
      public void run() {
        writeData(pos);
      }
    };

    Thread outThread = new Thread(runOutput, "outThread");
    outThread.start();

    Runnable runInput = new Runnable() {
      public void run() {
        readData(pis);
      }
    };

    Thread inThread = new Thread(runInput, "inThread");
    inThread.start();
  }
}