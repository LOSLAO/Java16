import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    //客户端的主要流程分为四步
    //1.从用户这里读取输入的数据
    //2.构造请求发送给服务器
    //3.从服务器读取响应
    //4.把响应写回客户端

    private DatagramSocket socket = null;
    private String serverIp;
    private int severPort;

    //需要在启动客户端的时候来指定需要连接哪个服务器

    public UdpEchoClient(String serverIp, int severPort) throws SocketException {
        this.serverIp = serverIp;
        this.severPort = severPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1.读取用户输入的数据
            System.out.println("-> ");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                break;
            }
            //2.构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), severPort);
            socket.send(requestPacket);
            //3.从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(requestPacket.getData(), 0, responsePacket.getLength()).trim();
            //4.显示响应数据
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
