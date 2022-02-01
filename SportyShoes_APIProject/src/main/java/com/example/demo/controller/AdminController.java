package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Admin;
import com.example.demo.model.Categorys;
import com.example.demo.model.Color;
import com.example.demo.model.Product;
import com.example.demo.model.PurchaseItem;
import com.example.demo.model.Season;
import com.example.demo.model.ShoeType;
import com.example.demo.model.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategorysRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseItemRepository;
import com.example.demo.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@author Kavitha S

@Api(value = "SwaggerAdminController", description = "REST Apis for the SportyShoe Purchase application!!!!")
@RestController
@RequestMapping("Admin")
public class AdminController {

	@Autowired
	AdminRepository adminrepo;

	@Autowired
	ProductRepository productrepo;

	@Autowired
	CategorysRepository categrepo;

	@Autowired
	UserRepository userrepo;

	@Autowired
	PurchaseItemRepository purchaserepo;
	
		

	/*
	 * ---------------------- Admin Operations ----------------------
	 */

	@ApiOperation(value = "Get list of admins in the system ", response = Iterable.class, tags = "Listadmin")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@GetMapping("Listadmin")
	public List<Admin> getAllAdmin() {
		List<Admin> admin = (List<Admin>) adminrepo.findAll();
		return admin;
	}

	@ApiOperation(value = "Add admin in the system ", response = Product.class, tags = "addadmins")
	@PostMapping("addadmin")
	public Admin addadmins(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}
	
	
	@ApiOperation(value = "Get specific admin in the system ", response = Product.class, tags = "getadminById")
	@GetMapping("admin/{id}")
	public Optional<Admin> getadminById(@PathVariable int id) {

		return adminrepo.findById(id);
	}

	@ApiOperation(value = "Update specific admin in the system ", response = Product.class, tags = "updateadminById")
	@PutMapping("update/{id}")
	public Admin updateadminById(@RequestBody Admin admin, @PathVariable int id) {
		admin.setID(id);
		return adminrepo.save(admin);
	}

	@ApiOperation(value = "Delete admin in the system ", response = Product.class, tags = "deleteadmin")
	@DeleteMapping("deleteadmin/{id}")
	public void deleteadmin(@PathVariable int id) {
		adminrepo.deleteById(id);
	}
	
	/*
	 * ---------------------- Category Operations ----------------------
	 */

	@ApiOperation(value = "Add category in the system ", response = Product.class, tags = "addcategory")
	@PostMapping("addcategory")
	public Categorys addcategory(@RequestBody Categorys category) {
		return categrepo.save(category);
	}

	@ApiOperation(value = "Update category in the system ", response = Product.class, tags = "updateCategory")
	@PutMapping("updatecategory/{id}")
	public Categorys updateCategory(@RequestBody Categorys category, @PathVariable int id) {
		category.setCategoryId(id);
		return categrepo.save(category);
	}

	@ApiOperation(value = "Delete category in the system ", response = Product.class, tags = "deleteCategory")
	@DeleteMapping("deletecategory/{id}")
	public void deleteCategory(@PathVariable int id) {
		categrepo.deleteById(id);
	}

	@ApiOperation(value = "List categories in the system ", response = Product.class, tags = "getAllcategory")
	@GetMapping("Listcategory")
	public List<Categorys> getAllcategory() {
		List<Categorys> category = (List<Categorys>) categrepo.findAll();
		System.out.println(category);
		return category;
	}


	@ApiOperation(value = "Get specific category in the system ", response = Product.class, tags = "getcategoryById")
	@GetMapping("category/{id}")
	public Optional<Categorys> getcategoryById(@PathVariable int id) {

		return categrepo.findById(id);
	}
	
	
	/*
	 * ---------------------- Product Operations ----------------------
	 */
	
	
	@ApiOperation(value = "Add product in the system ", response = Product.class, tags = "addProduct")
	@PostMapping("addproduct")
	public Product addProduct(@RequestBody Product product) {

		System.out.println(product);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String todaysdate = dateFormat.format(date);
		product.setCreatedDate(todaysdate);
		System.out.println(product);
		return productrepo.save(product);
	}

	@ApiOperation(value = "List products in the system ", response = Product.class, tags = "getAllproducts")
	@GetMapping("Listproducts")
	public List<Product> getAllproducts() {
		List<Product> product = (List<Product>) productrepo.findAll();
		return product;
	}
	
	
	@ApiOperation(value = "Delete product in the system ", response = Product.class, tags = "deleteProduct")
	@DeleteMapping("deleteproduct/{id}")
	public void deleteProduct(@PathVariable int id) {

		productrepo.deleteById(id);
	}

	@ApiOperation(value = "Update product in the system ", response = Product.class, tags = "updateproduct")
	@PutMapping("updateproduct/{id}")
	public Product updateproduct(@RequestBody Product product, @PathVariable("id") int id) {
		System.out.println(product);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String todaysdate = dateFormat.format(date);
		product.setCreatedDate(todaysdate);
		product.setProductId(id);
		System.out.println(product);
		return productrepo.save(product);
	}

	@ApiOperation(value = "Get specific product in the system ", response = Product.class, tags = "getprodById")
	@GetMapping("product/{id}")
	public Optional<Product> getprodById(@PathVariable int id) {

		return productrepo.findById(id);
	}

	@ApiOperation(value = "Get product by category in the system ", response = Product.class, tags = "getProdBycategory")
	@GetMapping("prodcategory/{category}")
	public List<Categorys> getProdBycategory(@PathVariable int category) {

		System.out.println(category);

		List<Categorys> prd = categrepo.findBycategoryId(category);
		System.out.println(prd);
		return prd;

	}

	@ApiOperation(value = "Get product by season in the system ", response = Product.class, tags = "getProdByseason")
	@GetMapping("prodseason/{season}")
	public List<Product> getProdByseason(@PathVariable Season season) {
		return productrepo.findByseason(season);

	}

	@ApiOperation(value = "Get product by shoetype in the system ", response = Product.class, tags = "getByshoetype")
	@GetMapping("prodshoetype/{shoetype}")
	public List<Product> getByshoetype(@PathVariable ShoeType shoetype) {
		return productrepo.findByshoetype(shoetype);

	}

	@ApiOperation(value = "Get product by price in the system ", response = Product.class, tags = "getProdByprice")
	@GetMapping("prodprice/{price}")
	public List<Product> getProdByprice(@PathVariable float price) {
		return productrepo.findByprice(price);

	}

	@ApiOperation(value = "Get product by color in the system ", response = Product.class, tags = "getProdBycolor")
	@GetMapping("prodcolor/{color}")
	public List<Product> getProdBycolor(@PathVariable Color color) {
		return productrepo.findBycolor(color);

	}

	@ApiOperation(value = "Get product by creation date in the system ", response = Product.class, tags = "getProdBycreatedDate")
	@GetMapping("proddate/{createdDate}")
	public List<Product> getProdBycreatedDate(@PathVariable String createdDate) {
		return productrepo.findBycreatedDate(createdDate);

	}

	/*
	 * ---------------------- User Operations ----------------------
	 */

	@ApiOperation(value = "Add user in the system ", response = Product.class, tags = "addusers")
	@PostMapping("addusers")
	public User addusers(@RequestBody User users) {

		return userrepo.save(users);
	}

	@ApiOperation(value = "List users in the system ", response = Product.class, tags = "getAllusers")
	@GetMapping("listusers")
	public List<User> getAllusers() {
		List<User> user = (List<User>) userrepo.findAll();
		return user;
	}
	

	@ApiOperation(value = "Get specific user in the system ", response = Product.class, tags = "getuserById")
	@GetMapping("user/{id}")
	public Optional<User> getuserById(@PathVariable int id) {

		return userrepo.findById(id);
	}
	
	
	@ApiOperation(value = "Delete user in the system ", response = Product.class, tags = "deleteuser")
	@DeleteMapping("deleteuser/{id}")
	public void deleteuser(@PathVariable int id) {

		userrepo.deleteById(id);
	}

	@ApiOperation(value = "Update user in the system ", response = Product.class, tags = "updateuser")
	@PutMapping("updateuser/{id}")
	public User updateuser(@RequestBody User user, @PathVariable int id) {
		user.setID(id);
		return userrepo.save(user);
	}

	/*
	 * ---------------------- Purchase Operations ----------------------
	 */

	@ApiOperation(value = "Add purchase item in the system ", response = Product.class, tags = "addpurchaseitem")
	@PostMapping("addpurchaseitem")
	public PurchaseItem addpurchaseitem(@RequestBody PurchaseItem purchaseitem) {
		System.out.println(purchaseitem);
		return purchaserepo.save(purchaseitem);
	}

	@ApiOperation(value = "Delete purchase item in the system ", response = Product.class, tags = "deletePurchase")
	@DeleteMapping("deletepurchase/{id}")
	public void deletePurchase(@PathVariable int id) {

		purchaserepo.deleteById(id);
	}

	@ApiOperation(value = "List purchase items in the system ", response = Product.class, tags = "getAllpurchaseitem")
	@GetMapping("listitem")
	public List<PurchaseItem> getAllpurchaseitem() {
		List<PurchaseItem> purchitems = (List<PurchaseItem>) purchaserepo.findAll();
		return purchitems;
	}
	

	@ApiOperation(value = "Get specific purchase item in the system ", response = Product.class, tags = "getpurchaseitemById")
	@GetMapping("purchaseitem/{id}")
	public Optional<PurchaseItem> getpurchaseitemById(@PathVariable int id) {

		return purchaserepo.findById(id);
	}
	
	
	@ApiOperation(value = "Update purchase item in the system ", response = Product.class, tags = "updatepurchase")
	@PutMapping("updatepurchase/{id}")
	public PurchaseItem updatepurchase(@RequestBody PurchaseItem purchaseitem, @PathVariable int id) {
		purchaseitem.setPurchaseId(id);
		System.out.println(purchaseitem);
		System.out.println(id);
		return purchaserepo.save(purchaseitem);
	}

	@ApiOperation(value = "Get purchase items by purchase date in the system ", response = Product.class, tags = "getpurchasedate")
	@GetMapping("purchasedate/{purchaseDate}")
	public List<PurchaseItem> getpurchasedate(@PathVariable String purchaseDate) {

		return purchaserepo.findBypurchaseDate(purchaseDate);

	}

	@ApiOperation(value = "Get purchase items by category in the system  ", response = Product.class, tags = "getpurchCategory")
	@GetMapping("prodpurchase/{purchCategory}")
	public List<PurchaseItem> getpurchCategory(@PathVariable int purchCategory) {

		return purchaserepo.findBypurchCategory(purchCategory);

	}

}
