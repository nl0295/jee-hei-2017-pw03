package hei.tp03.dao;

import hei.tp03.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,Long> {

    List<Client> findByNom(String pNom);
}
