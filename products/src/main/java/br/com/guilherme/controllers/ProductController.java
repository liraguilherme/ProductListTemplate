package br.com.guilherme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilherme.data.vo.v1.ProductVO;
import br.com.guilherme.data.vo.v2.ProductVOV2;
import br.com.guilherme.services.ProductServices;
import br.com.guilherme.util.MediaType;


@RestController
@RequestMapping("/product/v1")
public class ProductController {
	
	@Autowired
	private ProductServices service;
	

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML, 
		  MediaType.APPLICATION_YML
		  }) //Usamos o producer/consumes por conta do swagger
  public List <ProductVO> findAll() {
      return service.findAll();
  
  }
  
  
  @GetMapping(value = "/{id}",
		produces = { MediaType.APPLICATION_JSON,
				MediaType.APPLICATION_XML, 
				  MediaType.APPLICATION_YML
				}) //Usamos o producer/consumes por conta do swagger
  public ProductVO findById(@PathVariable (value = "id") Long id) {
      return service.findById(id);
    		  
  
  }
  

 
  @PostMapping(
		  consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, //Usamos o producer/consumes por conta do swagger
		  produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public ProductVO create(@RequestBody ProductVO product ) {
      return service.create(product) ;
 
  }
  
   
  @PostMapping( /*Adicionando o desciption para o nosso V2*/
		  value = "/v2", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, //Usamos o producer/consumes por conta do swagger
		  produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public ProductVOV2 createV2(@RequestBody ProductVOV2 product ) {
      return service.createV2(product) ;
 
  }
  

  
  @PutMapping(
		  consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, //Usamos o producer/consumes por conta do swagger 
		  produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public ProductVO update(@RequestBody ProductVO product ) {
      return service.update(product) ;
 
  }
  
  
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
       service.delete(id);
       return ResponseEntity.noContent().build(); //Para ao inves de retornar o status code 200 retornar 204
    		  
  
  }


}
