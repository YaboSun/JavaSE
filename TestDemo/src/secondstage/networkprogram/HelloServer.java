package networkprogram;

import java.net.Socket;
import java.util.Scanner;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        Scanner scanner = new Scanner(socket.getInputStream());
        scanner.useDelimiter("\n");
        if (scanner.hasNext()) {
            System.out.println("回应数据" + scanner.next());
        }

        scanner.close();
        socket.close();
    }
}
