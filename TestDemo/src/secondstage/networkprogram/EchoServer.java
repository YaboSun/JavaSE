package networkprogram;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class EchoThread implements Runnable {
    private Socket client;
    public EchoThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(client.getInputStream());
            PrintStream printStream = new PrintStream(client.getOutputStream());
            //控制多次操作
            boolean flag = true;
            while (flag) {
                if (scanner.hasNext()) {
                    //得到客户端发送的内容
                    String string = scanner.next().trim();
                    if (string.equals("bb")) {
                        printStream.println("拜拜");
                        flag = false;
                    } else {
                        printStream.println("ECHO: " + string);
                    }
                }
            }
            client.close();
            scanner.close();
            printStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
public class EchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        boolean flag = true;
        while (flag) {
            //连接客户端
            Socket client = server.accept();
            new Thread(new EchoThread(client)).start();
        }
        //得到客户端输入数据以及向客户端输出数据的对象
        server.close();
    }
}
