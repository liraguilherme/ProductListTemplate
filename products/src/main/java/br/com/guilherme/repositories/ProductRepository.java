package br.com.guilherme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
