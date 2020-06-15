package com.sc.app.boundary.controller;


import com.sc.app.boundary.dto.ProductDto;
import com.sc.app.boundary.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDto> findProductById(@PathVariable Long id) {
        ProductDto output = productService.findById(id);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        ProductDto output = productService.save(productDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
