package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap<>();
    //url中的参数和body中的参数都放到这个parameters hash表中
    private Map<String, String> parameters = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private String body;

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //1.处理首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //2.解析url
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String queryString = request.url.substring(pos + 1);
            parseKV(queryString, request.parameters);
        }
        //3.循环处理header部分
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0], headerTokens[1]);
        }
        //4.解析cookie
        String cookie = request.headers.get("Cookie");
        if (cookie != null) {
            //把cookie进行解析
            parseCookie(cookie, request.cookies);
        }
        //5.解析body
        if ("POST".equalsIgnoreCase(request.method)
                || "PUT".equalsIgnoreCase(request.method)) {
            //这两个方法需要处理body，其他暂时不考虑
            //需要把body读取出来
            //需要先知道body的长度，Content-length就是干这个的
            //此处的长度单位是“字节"
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            char[] buffer = new char[contentLength];
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer, 0, len);
        }
        return request;

    }

    private static void parseKV(String queryString, Map<String, String> parameters) {
        //1.按照&拆分成多个键值对
        String[] kvTokens = queryString.split("&");
        //2.按照=拆分成每个键和值
        for (String kv : kvTokens) {
            String[] result = kv.split("=");
            parameters.put(result[0], result[1]);
        }
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        //1.按照 分号空格拆分成多个键值对
        String[] kvTokens = cookie.split("; ");
        //2.按照=拆分成每个键和值
        for (String kv : kvTokens) {
            String[] result = kv.split("=");
            cookies.put(result[0], result[1]);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getBody() {
        return body;
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

}



