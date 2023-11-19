package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            System.out.println("mar7be bik fel chat ");
            // Obtenir l'adresse IP du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");
            // Spécifier le port du serveur
            int serverPort = 1234;
            // Scanner pour lire l'entrée utilisateur
            Scanner scanner = new Scanner(System.in);
            // Demander à l'utilisateur d'entrer son nom
            System.out.println("Name ");
            String username = scanner.nextLine();
            while (true) {
                // Demander à l'utilisateur d'entrer un message
                System.out.println(" message:\t");
                String message = scanner.nextLine();
                // Convertir le message en tableau de bytes
                byte[] sendData = (username + ": " + message).getBytes();
                // Créer un paquet avec les données à envoyer, l'adresse IP du serveur et le port du serveur
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                // Envoyer le paquet au serveur
                clientSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}