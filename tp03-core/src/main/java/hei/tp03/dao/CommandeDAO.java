package hei.tp03.dao;

import hei.tp03.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeDAO extends JpaRepository<Commande,Long> {
}
