package com.app.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pets")
public class Pets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long petid;
	private String name;
	private String type;
	private double price;
	
	public Long getPetid() {
		return petid;
	}
	public void setPetid(Long petid) {
		this.petid = petid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pets [petid=" + petid + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
	
	
	
	

}
