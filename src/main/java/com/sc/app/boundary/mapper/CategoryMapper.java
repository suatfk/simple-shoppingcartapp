package com.sc.app.boundary.mapper;

import com.sc.app.boundary.dto.CategoryDto;
import com.sc.app.domain.category.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CategoryDto categoryDto);

    CategoryDto map(Category category);

    List<CategoryDto> map(List<Category> categories);
}
