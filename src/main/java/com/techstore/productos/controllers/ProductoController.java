package com.techstore.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstore.productos.modelo.Producto;
import com.techstore.productos.servicies.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/techStore/productos")
@Tag(name = "Productos", description = "Gestion de los Productos de TechStore")
public class ProductoController {

	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@PostMapping
	@Operation(summary = "Crea un nuevo Producto", description = "Crea un nuevo producto con los datos requeridos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Se creo exitosamente el producto"),
			@ApiResponse(responseCode = "400", description = "Datos ingresados incorrectos")
	})
	public ResponseEntity<Producto> crearProducto(@RequestBody @Parameter(description = "Datos necesarios para crear un producto")
	Producto producto){
		Producto productoNuevo = productoService.guardarProducto(producto);
		return new ResponseEntity<>(productoNuevo, HttpStatus.CREATED);
	}
	
	@GetMapping
	@Operation(summary = "Lista todos los productos", description = "Obtiene una lista de todos los productos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista obtenida con exito"),
			@ApiResponse(responseCode = "500", description = "Error al obtener la lista")
	})
	public ResponseEntity<List<Producto>> listarProductos(){
		List<Producto> nuevaLista = productoService.listarProductos();
		return new ResponseEntity<>(nuevaLista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Busqueda en especifico", description = "Busca un producto por su id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busqueda con exito"),
			@ApiResponse(responseCode = "404", description = "Producto no encontrado con ese id")
	})
	public ResponseEntity<Producto> buscarPorId(@PathVariable @Parameter(description = "Id del producto") String id){
		Producto producto = productoService.buscarProductoPorId(id);
		if(producto != null) {
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Actualizacion Producto", description = "Actualiza completamente el producto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto actualizado completamente"),
			@ApiResponse(responseCode = "404", description = "Producto no encontrado") 
	})
	public ResponseEntity<Producto> actualizarProducto(@PathVariable @Parameter(description = "Id del producto")String id, 
			@RequestBody @Parameter(description = "datos a actualizar") Producto producto){
		Producto productoViejo = productoService.buscarProductoPorId(id);
		if(productoViejo != null) {
			Producto productoActualizado = productoService.actualizarProducto(producto);
			return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
}
