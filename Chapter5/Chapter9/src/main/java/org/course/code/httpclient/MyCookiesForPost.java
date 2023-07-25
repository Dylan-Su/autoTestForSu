package org.course.code.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    public void getUrl(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.uri");
    }

    @Test
    public void testPostCookies() throws IOException {
        String uri = bundle.getString("test.url");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie:cookies){
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println("key :" + key + "   ,value :" + value);
        }
    }

    @Test(dependsOnMethods = {"testPostCookies"})
    public void testPostMethod() throws IOException {
        String postUri = bundle.getString("test.post.with.cookies");
        String testPostUrl = this.url + postUri;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(testPostUrl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息，设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookie信息
        client.setCookieStore(this.cookieStore);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("返回结果为："+result);
        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化为JSON的对象
        JSONObject resultJson = new JSONObject(result);
        //获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        //具体的额判断返回的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
