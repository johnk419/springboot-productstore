package io.johnnathan.springboot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String productsPage(ModelMap modelMap) {
		modelMap.put("productList", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/products/{id}")
	public String getProduct(@PathVariable int id, ModelMap modelMap) {
		modelMap.put("product", productService.getProduct(id));
		return "productPage";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable int id) {
		productService.updateProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public void updateProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
}
