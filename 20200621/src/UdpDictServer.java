import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("love", "爱");
        dict.put("system", "系统");
        dict.put("shit", "屎");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "这超出了范围");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
