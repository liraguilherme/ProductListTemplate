package br.com.guilherme.data.vo.v1;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

//COMO É UM VO APAGAMOS TODAS AS ANNOTATIONS

@JsonPropertyOrder({"id", "name", "price"}) // ordem que queremos que seja serializado
//Extendemos o representation model para suportar o Hateoas
public class ProductVO extends RepresentationModel<ProductVO> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key; //Mudamos de id para key
		
	//@JsonProperty("product_name") - alteramos para o nome que queremos
	private String name;
	
	//@JsonIgnore Oculta o campo
	private String price;
	
	public ProductVO() {
	
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVO other = (ProductVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	

}