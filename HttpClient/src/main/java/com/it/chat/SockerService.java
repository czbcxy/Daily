package com.it.chat;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chengzhengbo
 * @Date 2017/12/18
 * @TIME 上午11:23
 */
public class SockerService {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("服务器启动.....");



            //湖区用户请求的信息
            InetAddress inetAddress = socket.getInetAddress();
            String mess = InetAddress.getLocalHost() + "";
            System.out.println("客户端 " + mess + " 已经连接到服务器");
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader buf = null;
            OutputStreamWriter outputStreamWriter = null;
            BufferedWriter buw = null;
            OutputStream outputStream = null;
            int i = 0;
            for (int j = 0; j < i; j++) {
                if (i < 99) {
                    i++;
                    inputStream = socket.getInputStream();
                    inputStreamReader = new InputStreamReader(inputStream);
                    buf = new BufferedReader(inputStreamReader);
                    //读取客户端的信息
                    String s = buf.readLine();
                    System.out.println("Carver_007: " + s);

                    //服务端响应客户端信息
                    outputStream = socket.getOutputStream();
                    outputStreamWriter = new OutputStreamWriter(outputStream);
                    buw = new BufferedWriter(outputStreamWriter);
                    buw.write(s + "\n");
                    buw.flush();
                    //关闭资源
                    buw.close();
                    outputStreamWriter.close();
                    inputStreamReader.close();
                    inputStream.close();
                    outputStream.close();
                    buf.close();
                }
            }
        } catch (Exception e) {
            System.out.println("服务初始化失败");
        }

    }

}
