package com.techstore.productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
		return new ResponseEntity<Producto>(productoNuevo, HttpStatus.CREATED);
	}
	
}
