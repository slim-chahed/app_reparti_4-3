package server;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.HashSet;

public class Server {
    private static final int SERVER_PORT = 1234;
    private static HashSet<InetAddress> clientAddresses = new HashSet<>();
    private static int clientPort = 9876;

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT))
        {
            System.out.println("the serv is on " + SERVER_PORT);
            // Boucle principale pour recevoir les messages des clients
            while (true) {
                // Préparer un tableau de bytes pour stocker les données reçues
                byte[] receiveData = new byte[1024];
                // Préparer un paquet pour recevoir les données du client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // Recevoir les données du client
                serverSocket.receive(receivePacket);
                // Obtenir l'adresse IP du client et le port du client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                // Ajouter l'adresse IP du client à la liste des clients
                clientAddresses.add(clientAddress);
                // Convertir les données reçues en une chaîne de caractères (message)
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // Afficher le message du client dans la console du serveur
                System.out.println("message from "+ clientPort + ": " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}