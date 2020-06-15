package com.sc.app.boundary.controller;


import com.sc.app.boundary.dto.CategoryDto;
import com.sc.app.boundary.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> findCategoryById(@PathVariable Long id) {
        CategoryDto output = categoryService.findById(id);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        CategoryDto output = categoryService.save(categoryDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
