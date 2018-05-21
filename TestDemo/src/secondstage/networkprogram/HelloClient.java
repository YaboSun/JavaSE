package networkprogram;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) throws Exception {
        //所有的服务器必须有端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待客户端连接
        System.out.println("等待客户端连接.....");
        Socket client = serverSocket.accept();
        //outputstream不方便进行内容的输出 使用printstream
        PrintStream printStream = new PrintStream(client.getOutputStream());
        printStream.println("Hello World");
        serverSocket.close();
        client.close();
        printStream.close();
    }
}
