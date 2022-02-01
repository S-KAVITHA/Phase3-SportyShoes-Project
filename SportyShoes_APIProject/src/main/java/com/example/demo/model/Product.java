package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@author Kavitha S

@Entity
@Table(name = "shoe_product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;

	@Column(name = "name")
	private String name;


	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id", nullable = true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Categorys category;

	@Enumerated(EnumType.STRING)
	private Season season;

	@Enumerated(EnumType.STRING)
	private ShoeType shoetype;

	@Column(name = "price")
	private float price;

	@Enumerated(EnumType.STRING)
	private Color color;

	@Column(name = "createdDate")
	private String createdDate;

	@Column(name = "discount")
	private String discount;

	@Column(name = "quantity")
	private int quantity;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Categorys getCategory() {
		return category;
	}

	public void setCategory(Categorys category) {
		this.category = category;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Product(int productId, String name, Categorys category, Season season, ShoeType shoetype, float price,
			Color color, String createdDate, String discount, int quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.season = season;
		this.shoetype = shoetype;
		this.price = price;
		this.color = color;
		this.createdDate = createdDate;
		this.discount = discount;
		this.quantity = quantity;
	}

	public ShoeType getShoetype() {
		return shoetype;
	}

	public void setShoetype(ShoeType shoetype) {
		this.shoetype = shoetype;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	  @Override public String toString() { return "Product [productId=" + productId
	  + ", name=" + name + ", category=" + category + ", season=" + season +
	  ", shoetype=" + shoetype + ", price=" + price + ", color=" + color +
	  ", createdDate=" + createdDate + ", discount=" + discount + ", quantity=" +
	  quantity + "]"; }
	 

}
