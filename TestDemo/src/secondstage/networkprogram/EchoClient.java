package networkprogram;

import com.sun.security.ntlm.Client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 9999);
        //用户键盘输入数据
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(client.getInputStream());
        input.useDelimiter("\n");
        scanner.useDelimiter("\n");
        PrintStream output = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            System.out.println("请输入要发送的数据： ");
            if (input.hasNext()) {
                String string = input.next().trim();
                //发送服务器端数据
                output.println(string);
                if (string.equalsIgnoreCase("bb")) {
                    flag = false;
                }
                if (scanner.hasNext()) {
                    //输出回应数据
                    System.out.println(scanner.next());
                }
            }
        }
        input.close();
        output.close();
        scanner.close();
        client.close();
    }
}
