package com.techstore.productos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techstore.productos.modelo.Producto;

@Repository
public class ProductoRepository {

	private final ArrayList<Producto> productos = new ArrayList<>();
	
	public Producto guardarProducto(Producto producto) {
		productos.add(producto);
		return producto;
	}
	
	public Producto buscarPorId(String id) {
		for (Producto producto : productos) {
			if(producto.getId().equals(id)) {
				return producto;
			}
		}
		return null;
	}
	
	public List<Producto> listarProductos(){
		return new ArrayList<>(productos);
	}
	
	public Producto actualizarProducto(Producto producto) {
		for(int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getId().equals(producto.getId())) {
				productos.set(i, producto);
				return producto;
			}
		}
		return null;
	}
	
	public void eliminarProducto(String id) {
		for(int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getId().equals(id)) {
				productos.remove(i);
			}
		}
	}
	
}
