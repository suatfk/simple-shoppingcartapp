package com.sc.app.boundary.mapper;

import com.sc.app.boundary.dto.ShoppingCartDto;
import com.sc.app.domain.cart.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {


    ShoppingCartDto map(ShoppingCart result);
}
