import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//表示一个HTTP请求，并负责解析
public class HttpRequest {
    private String method;
    // /index.html?a=10&b=20
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();

    //请求的构造逻辑，也使用工厂模式来构造
    //此处的参数，就是从socket中获取到的InputStream对象
    //这个过程本质上就是“反序列化"
    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        //此处的逻辑，不能把bufferReader写到try()中
        //一旦写进去之后意味着bufferReader就会被关闭，会影响到clientSocket的状态
        //等到最后整个请求处理完了，在统一关闭
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //此处的build的过程就是解析请求的过程
        //1.解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //2.解析url中的参数
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            //看看url中是否有？，如果没有，就说明不带参数，也就不必解析了
            //此处的parameters是希望包含整个参数部分的内容
            //pos表示？的下标
            // /index.html?a=10&b=20
            //parameters 的结果就相当于是 a=10&b=20
            String parameters = request.url.substring(pos + 1);
            //切分的最终结果,key a, value 10; key b, value 20;
            parseKV(parameters, request.parameters);
        }
        //3.解析header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0], headerTokens[1]);
        }
        //4.解析body
        return request;
    }

    private static void parseKV(String input, Map<String, String> output) {
        //1.先按照&切分成若干组键值对
        String[] kvTokens = input.split("&");
        //2.针对切分结果再分别进行按照=切分，就得到了建和值
        for (String kv : kvTokens) {
            String[] result = kv.split("=");
            output.put(result[0], result[1]);
        }
    }


    //给这个类构造一些getter方法
    //请求对象的内容应该是从网络上解析来的，用户不应该修改


    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    //此处的getter手动写，自动生成的版本是直接得到整个hash表
    //而我们需要的是根据key来获取值
    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", parameters=" + parameters +
                '}';
    }
}
