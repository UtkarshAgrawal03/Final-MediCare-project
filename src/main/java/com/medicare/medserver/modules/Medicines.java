package com.medicare.medserver.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicines {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String category;
	private double price;
	private String name;
	private String Brand;
	private String Description;
	private String image;
	public Medicines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicines(int id, String category, String name, String brand, String description, String image,double price) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		Brand = brand;
		Description = description;
		this.image = image;
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Medicines [id=" + id + ", category=" + category + ", price=" + price + ", name=" + name + ", Brand="
				+ Brand + ", Description=" + Description + ", image=" + image + "]";
	}
	
	

}
