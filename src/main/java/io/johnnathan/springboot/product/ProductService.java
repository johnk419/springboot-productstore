package io.johnnathan.springboot.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
    @Qualifier("mysql")
	private ProductDAO productDAO;
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}

	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}
}
