package com.chat;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author chengzhengbo
 * @Date 2017/12/19
 * @TIME 下午3:41
 */
public class HttpClent {
    public static void main(String[] args) throws IOException {
        Init("http://sc.chinaz.com/tupian/beijingtupian.html");
//        Init("http://588ku.com/beijing/");
//        Init("http://www.tooopen.com/img/87.aspx");
    }

    public static void Init(String URL) throws IOException {
        HttpClient httpClient = new HttpClient();
        HttpMethod method = new GetMethod(URL);
        httpClient.executeMethod(method);
        int statusCode = method.getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.err.println("Method failed: "
                    + method.getStatusLine());
        }
        byte[] body = method.getResponseBody();
        String html = new String(body);

        Document parse = Jsoup.parse(html);
        String title = parse.title();
        System.err.println(title);
        //拿到所有的a标签的图片
        Elements a1 = parse.getAllElements();
        //如果是img就下载出来
        Elements img = a1.select("img");
        if (img.size() > 0) {
            List<String> html1 = img.eachAttr("src2");
            List<String> html3 = img.eachAttr("src");

            if (html3.size() > 0) {
                for (int i = 0; i < html3.size(); i++) {
                    String url = html3.get(i);
                    Random random = new Random();
                    int i1 = random.nextInt(999);
                    download(url, i1 + "");
                }
            }
            if (html1.size() > 0) {
                for (int i = 0; i < html1.size(); i++) {
                    String url = html1.get(i);
                    Random random = new Random();
                    int i1 = random.nextInt(999);
                    download(url, i1 + "");
                }
            }
        }


        //如果是链接就进入
        Elements a = a1.select("a");
        List<String> html2 = a.eachAttr("href");

        for (int i = 0; i < html2.size(); i++) {
            String s = html2.get(i);
            if (s.endsWith("html") || s.endsWith("htm")) {
                try {
                    Init(s);
                } catch (Exception e) {
                    Init(html2.get(i + 1));
                }
            }
        }
    }

    public static void download(String listUrl, String alt) throws IOException {
        HttpClient httpClient = new HttpClient();
        GetMethod get = new GetMethod(listUrl);
        httpClient.executeMethod(get);
        String s = listUrl;
        String jpg = s.substring(s.lastIndexOf(".") + 1, s.length()).substring(0, 3);
        File storeFile = new File("/Users/chengzhengbo/czb/" + alt + "." + jpg);
        FileOutputStream output = new FileOutputStream(storeFile);
        //得到网络资源的字节数组,并写入文件
        output.write(get.getResponseBody());
        System.out.println("保存" + s + "  >>>>  名称" + alt + "." + jpg);
        output.close();
    }
}
