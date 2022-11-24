package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int N = scanner.nextInt(); // Для 30 задания можно вводить что угодно.

        try (Socket socket = new Socket("localhost", Server.PORT)) {
            try (var outputStream = socket.getOutputStream(); var inputStream = socket.getInputStream()) {
                var in = new BufferedReader(new InputStreamReader(inputStream));
                var out = new BufferedWriter(new OutputStreamWriter(outputStream));
                out.write(N + "\r");
                out.flush();
                System.out.println("Ответ: " + in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
