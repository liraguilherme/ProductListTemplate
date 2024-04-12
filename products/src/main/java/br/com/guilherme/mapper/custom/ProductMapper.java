package br.com.guilherme.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.guilherme.data.vo.v2.ProductVOV2;
import br.com.guilherme.model.Product;

/*
Criando mapper customizado para o V2 funcionar */

@Service
public class ProductMapper {
	
	     //Entidade para VO	
		public ProductVOV2 convertEntityToVO(Product product) {
		 ProductVOV2 vo = new ProductVOV2();
		 
		 //Copiar atributos de Person Para VO
		 vo.setId(product.getId());
		 vo.setName(product.getName());
		 vo.setPrice(product.getPrice());
		 vo.setDescription("Descrição...");
		 return vo;
		 
		 
		}
	
	     //VO para entidade	

public Product convertVoTOEntity(ProductVOV2 product) {
	 Product entity = new Product();
	 
	 //Copiar atributos de Person Para VO
	 entity.setId(product.getId());
	 entity.setName(product.getName());
	 entity.setPrice(product.getPrice());
	 //vo.setDescription("Descrição...");
	 return entity;
	 
	 
	}
}

	




