package io.johnnathan.springboot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/products")
	public String productsPage(ModelMap modelMap) {
		modelMap.put("productList", productService.getAllProducts());
		return "products";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products/add")
	public String addProductPage(ModelMap modelMap) {
		return "addProduct";
	}
	
	@RequestMapping("/products/{id}")
	public String getProduct(@PathVariable String id, ModelMap modelMap) {
		modelMap.put("product", productService.getProduct(id));
		return "productPage";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
//		log.info("test");
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id) {
		productService.updateProduct(product, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public void updateProduct(@PathVariable String id) {
		productService.deleteProduct(id);
	}
}
