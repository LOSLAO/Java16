import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    private ServerSocket serverSocket = null;

    public HttpServerV3(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }


    private void process(Socket clientSocket) {
        try {
            //1.读取请求并解析
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            //2.根据请求计算响应
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            } else {
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            //3.把响应写回客户端
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        //1.能够支持返回一个html文件
        if (request.getUrl().startsWith("/index.html")) {
            InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                response.writeBody(line + "\n");
            }
            bufferedReader.close();
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        //2.实现/login的处理
        if (request.getUrl().startsWith("/login")) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("userName: " + userName);
            System.out.println("password: " + password);
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 serverV3 = new HttpServerV3(9090);
        serverV3.start();
    }


}
