package org.course.code.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    public void testGetUri(){
        //去application.properties文件中取值
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.uri");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.url");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie :cookies){
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println("key:"+key + ",  value:" + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void getWithCookies() throws IOException {
        String testUrlWithCookies = this.url+bundle.getString("test.get.with.cookies");
        HttpGet get = new HttpGet(testUrlWithCookies);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置请求的cookies信息
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(get);

        //获取形影的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        if (statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}
