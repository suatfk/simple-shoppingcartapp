package com.sc.app.boundary.service;

import com.sc.app.boundary.dto.CategoryDto;
import com.sc.app.boundary.mapper.CategoryMapper;
import com.sc.app.domain.category.Category;
import com.sc.app.domain.category.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.map(category);
    }

    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryMapper.map(categoryDto);
        Category result = categoryRepository.save(category);
        return categoryMapper.map(result);
    }
}
