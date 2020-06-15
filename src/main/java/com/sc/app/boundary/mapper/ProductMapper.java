package com.sc.app.boundary.mapper;

import com.sc.app.boundary.dto.ProductDto;
import com.sc.app.domain.product.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(ProductDto productDto);

    ProductDto map(Product product);

    List<ProductDto> map(List<Product> products);
}
