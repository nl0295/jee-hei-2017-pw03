package hei.tp03.service;

import hei.tp03.entity.Client;

import java.util.List;

/**
 * Created by nicol on 17/01/2017.
 */
public interface ClientService {

    List<Client> findByNom(String pNom);

    void saveClient(Client pClient);

    List<Client> findAll();
}
