package com.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chengzhengbo
 * @Date 2017/12/19
 * @TIME 下午12:15
 */
public class ServiceSocketThrear implements Runnable {


    private ServerSocket serverSocket;


    public ServiceSocketThrear(ServerSocket serverSocket) {
        serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            if (serverSocket == null) {
                Socket socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
