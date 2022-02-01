package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@author Kavitha S

@Entity
@Table(name = "shoe_category")


@NamedEntityGraph(name="graph.Categorys.products", attributeNodes = @NamedAttributeNode(value="products"))

public class Categorys {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int categoryId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products = new HashSet<Product>();
	
	

	public Categorys(int categoryId, String name, Set<Product> products) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.products = products;
	}

	public Categorys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
}

	
