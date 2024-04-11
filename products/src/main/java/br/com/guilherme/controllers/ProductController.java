package br.com.guilherme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import br.com.guilherme.services.ProductServices;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServices service;
	

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //Usamos o producer/consumes por conta do swagger
  public List <ProductVO> findAll() {
      return service.findAll();
  
  }
  
  
  @GetMapping(value = "/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE) //Usamos o producer/consumes por conta do swagger
  public ProductVO findById(@PathVariable (value = "id") Long id) {
      return service.findById(id);
    		  
  
  }
  

  
  @PostMapping(
		  consumes = MediaType.APPLICATION_JSON_VALUE,//Usamos o producer/consumes por conta do swagger
		  produces = MediaType.APPLICATION_JSON_VALUE)
  public ProductVO create(@RequestBody ProductVO product ) {
      return service.create(product) ;
 
  }
  

  
  @PutMapping(
		  consumes = MediaType.APPLICATION_JSON_VALUE,//Usamos o producer/consumes por conta do swagger 
		  produces = MediaType.APPLICATION_JSON_VALUE)
  public ProductVO update(@RequestBody ProductVO product ) {
      return service.update(product) ;
 
  }
  
  
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
       service.delete(id);
       return ResponseEntity.noContent().build(); //Para ao inves de retornar o status code 200 retornar 204
    		  
  
  }


}
