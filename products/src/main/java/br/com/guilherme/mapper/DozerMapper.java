package br.com.guilherme.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
	
	//Implementação do Dozer
	
	//Vai converter VO em entidades, e entidades em objetos
	
	//Inicializando o mapper
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	//Conversão de um objeto simples
	//tem 2 tipos Origem e Destino e retorna o destino
	public static<O, D> D parseObject(O origin, Class<D> destination){
		return mapper.map(origin, destination);
	}
		
		//Conversão de um objeto de lista (retorna qualquer tipo de objeto desde que seja entidade/VO)
		public static<O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
		    List<D> destinationObjects = new ArrayList<D>();
		    
		    //Conversão da lista de origem um a um no objeto de destino pelo metodo for each
	        for (O o : origin) {
	        	
	        	//Para cada item vamos converter e adicionar em destinationObjects
	        	destinationObjects.add(mapper.map(o, destination)); //Convertemos item por item em objeto de destino
	        }
		    
		    return destinationObjects;

	}

}
