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
import br.com.guilherme.services.ProductServices;
import br.com.guilherme.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/product/v1")
//Configuração Swagger titulo e descrição
@Tag(name = "Product", description = "Endpoints for Managing Product")
public class ProductController {
	
	@Autowired
	private ProductServices service;
	

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML, 
		  MediaType.APPLICATION_YML
		  }) //Usamos o producer/consumes por conta do swagger
  
  //Configurando Swagger GetAll
 @Operation(summary = "Finds all Product", description = "Finds All Product",
 tags = {"Product"}, 
 responses = {
		 @ApiResponse(description = "Success", responseCode = "200", 
				 content = { @Content(
						 mediaType = "application/json",
						 array = @ArraySchema(schema = @Schema(implementation = ProductVO.class)))}),
		 
		 @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		 @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		 @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		 @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

 })
  
  public List <ProductVO> findAll() {
      return service.findAll();
  
  }
  
  @GetMapping(value = "/{id}",
		produces = { MediaType.APPLICATION_JSON,
				MediaType.APPLICATION_XML, 
				  MediaType.APPLICATION_YML
				}) //Usamos o producer/consumes por conta do swagger
 
//Configurando Swagger FINDBYID
 @Operation(summary = "Finds a Product", description = "Finds a Product",
 tags = {"Product"}, 
 responses = {
		 @ApiResponse(description = "Success", responseCode = "200", 
				 content = @Content(schema = @Schema(implementation = ProductVO.class))),
		 
		 @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
	     @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		 @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		 @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		 @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

 })
  
  public ProductVO findById(@PathVariable (value = "id") Long id) {
      return service.findById(id);
    		  
  
  }
  

 
  @PostMapping(
		  consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, //Usamos o producer/consumes por conta do swagger
		  produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  
//Configurando Swagger POST
 @Operation(summary = "Adds a new Product", description = "Adds a new Product",
 tags = {"Product"}, 
 responses = {
		 @ApiResponse(description = "Success", responseCode = "200", 
				 content = @Content(schema = @Schema(implementation = ProductVO.class))),
		 
	     @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		 @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		 @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

 })
  public ProductVO create(@RequestBody ProductVO product ) {
      return service.create(product) ;
 
  }

  
  @PutMapping(
		  consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, //Usamos o producer/consumes por conta do swagger 
		  produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  
//Configurando Swagger UPDATE
  @Operation(summary = "Updates a Product", description = "Updates a Product",
  tags = {"Product"}, 
  responses = {
 		 @ApiResponse(description = "Updated", responseCode = "200", 
 				 content = @Content(schema = @Schema(implementation = ProductVO.class))),
 		 
 	     @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
 		 @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
 		 @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
 		 @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

  })
  public ProductVO update(@RequestBody ProductVO product ) {
      return service.update(product) ;
 
  }
  
  
  @DeleteMapping(value = "/{id}")
 
//Configurando Swagger DELETE
  @Operation(summary = "Deletes a Product", description = "Deletes a Product",
  tags = {"Product"}, 
  responses = {
 		 @ApiResponse(description = "No content", responseCode = "204", content = @Content),
 		 @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
 		 @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
 		 @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
 		 @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

  })
  public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
       service.delete(id);
       return ResponseEntity.noContent().build(); //Para ao inves de retornar o status code 200 retornar 204
    		  
  
  }


}
