package com.techstore.productos.modelo;



public class Producto {

	private String nombre;
	private String id;
	private String descripcion;
	private double precio;
	private int stock;
	
	public Producto() {
	}
	
	public Producto(String nombre, String id, String descripcion, double precio, int stock) {
		this.nombre = nombre;
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion() {
		this.descripcion = descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
	
	
	
}
