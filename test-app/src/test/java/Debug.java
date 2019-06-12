import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Debug {

    @Test
    public void testOkHttp() throws IOException{
        String result = get("https://tut.by", 500);
    }

    public String get(String url, int expectedCode) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                    .url(url)
                    .build();

        Response response = client.newCall(request).execute();
        Assert.assertEquals("Code is unexpected", expectedCode, response.code());
        return response.body().string();

    }
}
