/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.socket.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import sun.net.www.http.HttpClient;

public class ClientSocket3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 30000);
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNext()){
                String str = scanner.next();
                int type = 1;
                byte[] data = str.getBytes();
                int len = data.length + 5;
                dataOutputStream.writeByte(type);
                dataOutputStream.writeInt(len);
                dataOutputStream.write(data);
                dataOutputStream.flush();
                //socket.shutdownOutput();
              //  socket.shutdownInput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
