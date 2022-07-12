package base.test.net;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @ClassName TestHttp
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-10 12:24
 * @Version 1.0
 */
public class TestHttp {
    public static void main(String[] args) throws IOException, InterruptedException {
        TestHttp testHttp = new TestHttp();
        testHttp.testHttp();;
    }
    public void testHttp() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.r2coding.com"))
                .GET()
                .build();
        var httpResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}
