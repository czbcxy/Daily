package com.it.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author chengzhengbo
 * @Date 2017/12/18
 * @TIME 下午5:50
 */
public class SockerClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);






        InputStream inputStream = null;
        OutputStream outputStream = null;
        OutputStreamWriter ouw = null;
        BufferedWriter buw = null;
        Scanner scanner = null;
        InputStreamReader inr = null;
        BufferedReader bur = null;
        int i = 0;
        if (i < 99) {
            i++;
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            //向服务器发送一条信息测试
            ouw = new OutputStreamWriter(outputStream);
//            buw = new BufferedWriter(ouw);
            scanner = new Scanner(System.in);
            String s = scanner.next();
            ouw.write(s + " \n");
            ouw.flush();

            //接收服务端的信息
            inr = new InputStreamReader(inputStream);
            bur = new BufferedReader(inr);
            //打印登录成功
            System.out.println("服务端: " + bur.readLine());

            //关闭资源
            bur.close();
            inr.close();
            ouw.close();
            inputStream.close();
            outputStream.close();
        }

    }
}
