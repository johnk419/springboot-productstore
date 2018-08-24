package io.johnnathan.springboot.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private List<Product> products = new ArrayList<Product>(Arrays.asList(
			new Product("123", "Fern", "A Fern lel"),
			new Product("124", "Tree", "A Tree lel"),
			new Product("125", "Car", "A Car lel")));
	
	public List<Product> getAllProducts() {
		return products;
	}
	
	public Product getProduct(String id) {
		return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void updateProduct(Product product, String id) {
		for (int i = 0; i < products.size(); ++i) {
			Product p = products.get(i);
			if (p.getId().equals(id)) {
				products.set(i, product);
				return;
			}
		}
	}

	public void deleteProduct(String id) {
		for (int i = 0; i < products.size(); ++i) {
			Product p = products.get(i);
			if (p.getId().equals(id)) {
				products.remove(i);
				return;
			}
		}	
	}
}
