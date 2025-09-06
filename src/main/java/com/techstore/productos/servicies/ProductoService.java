package com.techstore.productos.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techstore.productos.modelo.Producto;
import com.techstore.productos.repositories.ProductoRepository;

@Service
public class ProductoService {

	private final ProductoRepository productoRepository;
	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public Producto guardarProducto(Producto producto){
		return productoRepository.guardarProducto(producto);
	}
	
	public Producto buscarProductoPorId(String id) {
		return productoRepository.buscarPorId(id);
	}
	
	public List<Producto> listarProductos(){
		return productoRepository.listarProductos();
	}
	
	public Producto actualizarProducto(Producto producto) {
		return productoRepository.actualizarProducto(producto);
	}
	
	public void eliminarProducto(String id) {
		productoRepository.eliminarProducto(id);
	}
	
	
	
	
	
	
}
