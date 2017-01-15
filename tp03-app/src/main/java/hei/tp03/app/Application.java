package hei.tp03.app;

import hei.tp03.entity.Client;
import hei.tp03.entity.Commande;
import hei.tp03.entity.Produit;
import hei.tp03.service.ClientService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

    private static Random random = new SecureRandom();

    private static String[] allProduits = new String[] { "pomme", "tomate", "poire", "carotte", "cornichon", "kiwi", "ananas", "courgette", "aubergine", "patate" };


    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("hei.tp03.config");
        ClientService clientService = context.getBean(ClientService.class);
        List<Client> clients = getClients();
        for (Client client : clients) {
            clientService.saveClient(client);
        }
        context.close();
    }


    private static List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Michu", "Germaine"));
        clients.add(new Client("Michu", "Ghislain"));
        clients.add(new Client("Dupont", "Marcel"));
        clients.add(new Client("Lefebvre", "Jacky"));
        clients.add(new Client("Duval", "Janine"));
        setCommandes(clients);
        return clients;
    }


    private static void setCommandes(List<Client> clients) {
        for (Client client : clients) {
            List<Commande> commandes = new ArrayList<>();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                System.out.println("Ajout d'une commande pour le client " + client.getNom());
                commandes.add(new Commande(client));
            }
            setProduits(commandes);
            client.setCommandes(commandes);
        }
    }


    private static void setProduits(List<Commande> commandes) {
        for (Commande commande : commandes) {
            List<Produit> produits = new ArrayList<>();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                String nomProduit = allProduits[random.nextInt(allProduits.length)];
                System.out.println("Ajout du produit " + nomProduit + " à la commande");
                produits.add(new Produit(nomProduit, commande));
            }
            commande.setProduits(produits);
        }
    }
}
