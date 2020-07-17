/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.socket.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocket2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 30000);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                // 如果没有这一句，服务端就不会认为一行数据的结束，这时如果中断客户端的执行，之前输入的数据会在服务端输出
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                // 注意：客户端没有写socket.close() 或者调用socket.shutdownOutput();
                // 服务端是如何知道客户端已经输入完成了？服务端接受数据的时候是如何判断客户端已经输入完成呢？这就是一个核心点，双方约定一个标识，当客户端发送一个标识给服务端时，表明客户端端已经完成一个数据的载入。而服务端在结束数据的时候，也通过这个标识进行判断，如果接受到这个标识，表明数据已经传入完成，那么服务端就可以将数据度入后显示出来。

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
