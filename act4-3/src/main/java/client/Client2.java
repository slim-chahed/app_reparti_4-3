package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            System.out.println("mar7be bik fel chat ");
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1234;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Name ");
            String username = scanner.nextLine();
            while (true) {
                System.out.println(" message:\t");
                String message = scanner.nextLine();
                byte[] sendData = (username + ": " + message).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}