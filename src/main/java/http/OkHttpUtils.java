package http;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author xulin
 * <p>2020/4/20 10:23</p>
 * <p>该类用于利用okhttp发送请求</p>
 */
public class OkHttpUtils {

    /**
     * 默认客户端
     */
    private static OkHttpClient client;
    /**
     * 链接超时时间
     */
    private static long CONNECT_TIMEOUT = 5;
    /**
     * 读超时时间
     */
    private static long READ_TIME = 10;
    /**
     * 写超时时间
     */
    private static long WRITE_TIMEOUT = 10;

    static {
        //初始化 默认客户端
        if (client == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder = okHttpClient.newBuilder();
            builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
            builder.readTimeout(READ_TIME, TimeUnit.SECONDS);
            builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
            client = builder.build();
        }
    }

    /**
     * 自定义客户端
     *
     * @param connectTime
     * @param readTimeout
     * @param writeTimeout
     * @return
     */
    public OkHttpClient getCustomClient(int connectTime, int readTimeout, int writeTimeout) {
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        builder.connectTimeout(connectTime, TimeUnit.SECONDS);
        builder.readTimeout(readTimeout, TimeUnit.SECONDS);
        builder.writeTimeout(writeTimeout, TimeUnit.SECONDS);
        return builder.build();
    }


    /**
     * 普通 get请求 返回 String
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        Request request = buildRequest(url, false, null, null);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * get 方法获取html
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static int getHttpStatus(String url) throws IOException {
        Request request = buildRequest(url, false, null);
        Response response = client.newCall(request).execute();
        int result = response.code();
        response.close();
        return result;
    }

    /**
     * 普通 post 请求 返回 string
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(OkHttpClient client, String url, Map<String, Object> params, Map<String, Object> headers) throws IOException {
        Request request = buildRequest(url, true, params, headers);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 普通 post 请求 返回 string
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, Object> params) throws IOException {

        Request request = buildRequest(url, true, params);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 生成请求方法
     *
     * @param url
     * @param methodFlag true post false get
     * @param params
     * @return
     */
    private static Request buildRequest(String url, boolean methodFlag, Map<String, Object> params) {

        Request.Builder builder = new Request.Builder().url(url);

        if (methodFlag) {
            RequestBody body = builderFormData(params);
            builder.post(body);
        } else {
            builder.get();
        }
        return builder.build();
    }

    /**
     * 生成请求方法
     *
     * @param url
     * @param methodFlag true post false get
     * @param params
     * @return
     */
    private static Request buildRequest(String url, boolean methodFlag, Map<String, Object> params, Map<String, Object> headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null && !headers.entrySet().isEmpty()) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        if (methodFlag) {
            RequestBody body = builderFormData(params);
            builder.post(body);
        } else {
            builder.get();
        }
        return builder.build();
    }

    /**
     * post 方法 生成 请求体 只适用于 String 类型
     *
     * @param params
     * @return
     */
    private static RequestBody builderFormData(Map<String, Object> params) {
        FormBody.Builder builder = new FormBody.Builder();

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (isEmpty(entry.getValue())) {
                    continue;
                }
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        return builder.build();
    }


    /**
     * post json 数据
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String postJson(OkHttpClient client, String url, String json) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static void main(String[] args) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("photographerCode", "100000010");
            map.put("potographerId", "2");
            map.put("token", "e76bc408f5204dc487e8a4630aca0515");
            System.out.println(post(client, "http://127.0.0.1/test", map, null));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
