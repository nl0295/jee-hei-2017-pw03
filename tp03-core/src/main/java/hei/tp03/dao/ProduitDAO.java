package hei.tp03.dao;

import hei.tp03.entity.Client;
import hei.tp03.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitDAO extends JpaRepository<Produit,Long> {
}
