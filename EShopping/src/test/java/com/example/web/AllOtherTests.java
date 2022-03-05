package com.example.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.web.model.Address;
import com.example.web.model.Cart;
import com.example.web.model.Category;
import com.example.web.model.Orders;
import com.example.web.model.Product;
import com.example.web.model.User;
import com.example.web.repository.AddressRepository;
import com.example.web.repository.CartRepository;
import com.example.web.repository.CategoryRepository;
import com.example.web.repository.OrderRepository;
import com.example.web.repository.ProductRepository;
import com.example.web.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AllOtherTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository ordersRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TestEntityManager entityManager;

	// UserTestCases save data matching
	@Test
	public void TestCreateUser() {
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("umesh");
		user.setLastName("Gawande");
		user.setEmail("umesh@gmail.com");
		user.setPassword("123456");

		User saveUser = userRepository.save(user);
		User exitUser = entityManager.find(User.class, saveUser.getId());
		// assertThat(exitUser.getEmail()).isNotEqualTo(user.getEmail());
		assertThat(user.getEmail()).isEqualTo(exitUser.getEmail());

	}
	// Order Testing save data matching

	@Test
	public void TestCreateOrder() {
		Orders order = new Orders();
		order.setOrderId(44L);
		order.setOrderStatus("Done");

		Orders saveOrder = ordersRepository.save(order);
		Orders exitOrder = entityManager.find(Orders.class, saveOrder.getOrderId());
		assertThat(order.getOrderStatus()).isEqualTo(exitOrder.getOrderStatus());
	}

	// Product Testing save data matching
	@Test
	void TestCreateProduct() {

		Product product = new Product();
		product.setProductId(101L);
		product.setProductname("Laptop");
		product.setPrice(56000.00);
		product.setColor("black");
		product.setManufacture("Dell");
		product.setSpecification("Intel5");
		product.setQuantity(1);

		Product savedProduct = productRepository.save(product);
		Product exitProduct = entityManager.find(Product.class, savedProduct.getProductId());

		assertThat(product.getProductname()).isEqualTo(exitProduct.getProductname());

	}

	// Cart Testing save data matching
	@Test
	void TestCreateCart() {

		Cart cart = new Cart();
		cart.setCartId(1L);
		cart.setSubTotal(45.00);

		Cart savedCart = cartRepository.save(cart);
		// savedCart.setSubTotal(55.00); //update value
		cartRepository.save(savedCart); // update value

		Cart exitCart = entityManager.find(Cart.class, savedCart.getCartId());
		assertThat(cart.getSubTotal()).isEqualTo(exitCart.getSubTotal());

	}

	// category testing save data matching
	@Test
	void TestCreateCategory() {
		Category category = new Category();
		category.setCategoryId("L1");
		category.setCategoryName("mobile");

		Category savedCategory = categoryRepository.save(category);
		Category exitCategory = entityManager.find(Category.class, savedCategory.getCategoryId());

		assertThat(category.getCategoryName()).isEqualTo(exitCategory.getCategoryName());
	}

	// Address Testing save data matching
	@Test
	void TestCreateAddress() {
		Address address = new Address();
		address.setAddressId(1L);
		address.setBuildingName("S.N.Niwas");
		address.setStreetNo("562 Pune");
		address.setCity("pune");
		address.setPincode("431001");
		address.setState("Maharashtra");
		address.setCountry("India");

		Address saveAddress = addressRepository.save(address);
		Address exitAddress = entityManager.find(Address.class, saveAddress.getAddressId());

		assertThat(address.getCity()).isLowerCase();
		assertThat(address.getCity()).isEqualToIgnoringCase(exitAddress.getCity());
	}

}
