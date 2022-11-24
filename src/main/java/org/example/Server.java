package org.example;

import java.io.*;
import java.net.ServerSocket;

public class Server {

    public static int PORT = 10010;

    public static void main(String[] args) {
        try (var serverSocket = new ServerSocket(PORT)) {
            while (true) {
                var client = serverSocket.accept();
                try (var inputStream = client.getInputStream(); var outputStream = client.getOutputStream()) {
                    var in = new BufferedReader(new InputStreamReader(inputStream));
                    var out = new BufferedWriter(new OutputStreamWriter(outputStream));
                    out.write(handle(in.readLine()) + "\r");
                    out.flush();
                }
                client.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String handle(String input) { //Выюираем как будем обрабатывать входное значение.
        return String.valueOf(twentyFour(Integer.parseInt(input)));
//        return String.valueOf(twentySeven(Integer.parseInt(input)));
//        return String.valueOf(thirty());
    }

    private static int twentyFour(int N) { //24
        int degree = (int) (Math.log(N) / Math.log(5));
        return (int) Math.pow(5, degree + 1);
    }

    private static boolean twentySeven(int N) { //27
        return (Math.log(N) / Math.log(4)) % 1 == 0;
    }

    private static double thirty() { //30
        for (int n = 1;; n++) {
            double result = Math.cos(Math.cos(n) / Math.sin(n));
            if (result < 0) return result;
        }
    }

}
