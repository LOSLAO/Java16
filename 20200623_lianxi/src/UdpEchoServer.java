import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1.读取请求解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),
                    0, requestPacket.getLength()).trim();
            //2.根据请求计算响应
            String response = process(request);
            //3.把响应结果写回到客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);

            System.out.printf("[%s:%d] rep: %s; resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }


}