package com.aethos.aethosmarket.persistence.mapper;

import com.aethos.aethosmarket.domain.service.PurchaseItem;
import com.aethos.aethosmarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})// esto se ahce con el fin de inyectarlo en el primer mapper
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source ="id.idProducto", target="productId"),
            @Mapping(source ="cantidad", target="quantity"),
            @Mapping(source ="estado", target="active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration//el mapeo de abajo utilizara de manera inversa el mapping definidio arriba
    @Mappings({
            @Mapping(target ="compra", ignore = true),
            @Mapping(target ="producto", ignore = true),
            @Mapping(target="id.idCompra", ignore = true),

    })
    ComprasProducto toComprasProducto(PurchaseItem item);


}
