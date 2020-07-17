/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.socket.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 创建socket对象有多种方式，可以看到Socket的构造器有多个
 *
 * 网络通讯中，一旦使用ServerSocket建立了连接，程序通过网络通讯与普通IO没有太大区别
 *
 * 我们知道，再服务端Socket的accept方法（接受客户端的连接）是阻塞的（方法停留在此处，不往下执行），那么什么时候才能往下执行呢？
 * 当执行了这个Socket socket = new Socket("127.0.0.1",9999);后，服务端的accept就会继续往下执行。
 *
 */
public class ClientSocket {
    public static void main(String[] args) {
        try {
            // 这种创建socket对象的方式，没有指定本地ip和端口，相当于默认了本地的socket的ip为127.0.0.1和端口是随机分配的端口
            Socket socket = new Socket("127.0.0.1", 9999);
            // 设置连接超时时间
            socket.setSoTimeout(10000);

            // 这种方式可以设置连接的超时时间
            Socket socket1 = new Socket();
            socket1.connect(new InetSocketAddress("127.0.0.1", 9999), 10000);


            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "你好，这是我的第一个socket";
            bufferedWriter.write(str);
            // 刷新输出流
            bufferedWriter.flush();
            // socket.shutdownOutput()是将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接受的
            // 这个地方即使没有关闭服务端也能打印数据，原因是客户端结束了，，服务端当然打印出了数据。
            // 如果先睡眠5s， 会发现服务端也要等5s，即客户端结束时才打印出数据,说明了客户端一定要有结束的标志才会导致服务端的打印
            socket.shutdownOutput();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println("来自服务端的数据：" + line);
            br.close();
            //  将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
