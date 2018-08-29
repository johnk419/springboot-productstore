package io.johnnathan.springboot.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class ProductDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setDescription(resultSet.getString("description"));
			return product;
		}	
	}
	
	public List<Product> getAllProducts() {
		final String sql = "SELECT id, name, description FROM products";
		List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());
		return products;
	}
	
	public Product getProduct(int id) {
		final String sql = "SELECT id, name, description FROM products WHERE id = ?";
		Product product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
		return product;
	}

	public void addProduct(Product product) {
		final String sql = "INSERT INTO products (name, description) VALUES (?, ?)";
		final String name = product.getName();
		final String description = product.getDescription();
		jdbcTemplate.update(sql, new Object[] {name, description});
	}

	public void updateProduct(Product product) {
		final String sql = "UPDATE name = ?, description = ? WHERE id = ?";
		int id = product.getId();
		final String name = product.getName();
		final String description = product.getDescription();
		jdbcTemplate.update(sql, new Object[] {name, description, id});
	}

	public void deleteProduct(int id) {
		jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
	}
	
	public void deleteProduct(Product product) {
		int id = product.getId();
		jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
	}
}
