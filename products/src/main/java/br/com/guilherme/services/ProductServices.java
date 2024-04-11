package br.com.guilherme.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.data.vo.v1.ProductVO;
import br.com.guilherme.exceptions.ResourceNotFoundException;
import br.com.guilherme.mapper.DozerMapper;
import br.com.guilherme.model.Product;
import br.com.guilherme.repositories.ProductRepository;


@Service
public class ProductServices {
	
	private Logger logger = Logger.getLogger(ProductServices.class.getName());
	
	@Autowired
	ProductRepository repository;

	public List<ProductVO> findAll() {
		
		logger.info("Finding all products!");

		//Converter a listagem de entidade product para VO, Convertemos para ProductVO.class
		return DozerMapper.parseListObject(repository.findAll(), ProductVO.class);
		
	}


	public ProductVO findById(Long id) {
		
		logger.info("Finding one product!");
				
		var entity = repository.findById(id)
				
		//Para caso não ache nenhuma id usamos
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	
		//Convertendo para VO
		return DozerMapper.parseObject(entity, ProductVO.class);
	}
	
	public ProductVO create(ProductVO product) { //Recebemos um vo (product)
		logger.info("Creating one product!");
		
		//Convertendo VO para entidade do tipo product
		var entity = DozerMapper.parseObject(product, Product.class);
		
		//Salvamos o obbjeto no banco pegamos o resultado e passamos para VO
		var vo = DozerMapper.parseObject(repository.save(entity), ProductVO.class);
		
		return vo;
	 
	}
	
	
	public ProductVO update(ProductVO product) {
		logger.info("Updating one product!");
		
		//Chamamos o produto que vai ser recuperado de entity do tipo product
		var entity = repository.findById(product.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		   
		//Pega o que ta no banco e seta nos devidos objetos
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		
		//Salvamos o obbjeto no banco pegamos o resultado e passamos para VO
		var vo = DozerMapper.parseObject(repository.save(entity), ProductVO.class);
		
		return vo;
		   
		   
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one product!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(entity);
	}
	


}
	
