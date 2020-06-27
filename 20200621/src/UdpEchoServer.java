import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //对于一个服务器程序来说，核心操作也是要分成两步
    //1.进行初始化操作（实例化Socket对象）
    //2.进入主循环，接受并处理请求
    //   a)读取数据并解析
    //   b)根据请求计算响应
    //   c)把响应结果写回到客户端
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //a)读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),
                    0, requestPacket.getLength()).trim();
            //b)根据请求计算响应
            String response = process(request);
            //c)把响应写回到客户端，响应数据就是response，需要包装一个Packet对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(requestPacket);

            //打印一条请求日志
            System.out.printf("[%s:%d] rep: %s; resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }
    public String process(String request) {
        // 由于此处是一个 echo server, 请求内容是啥, 响应内容就是啥.
        // 如果是一个更复杂的服务器, 此处就需要包含很多的业务逻辑来进行具体的计算.
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
