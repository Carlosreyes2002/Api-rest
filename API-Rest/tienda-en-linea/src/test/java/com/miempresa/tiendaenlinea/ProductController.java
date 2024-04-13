package com.miempresa.tiendaenlinea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));

        product.setNombre(productDetails.getNombre());
        product.setMarca(productDetails.getMarca());
        product.setDescripcion(productDetails.getDescripcion());
        product.setPrecio(productDetails.getPrecio());

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: " + id));

        productRepository.delete(product);
    }
}

