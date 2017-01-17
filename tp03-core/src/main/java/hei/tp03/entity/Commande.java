package hei.tp03.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean validee;

    @ManyToOne
    private Client client;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "commande")
    private List<Produit> produits;

    public Commande(){}

    public Commande(Client pClient){
        client=pClient;
    }


    public long getId() {
        return id;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
