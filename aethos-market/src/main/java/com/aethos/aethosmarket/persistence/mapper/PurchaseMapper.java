package com.aethos.aethosmarket.persistence.mapper;

import com.aethos.aethosmarket.domain.service.Purchase;
import com.aethos.aethosmarket.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={PurchaseItemMapper.class})//internamente se mapeara dentro de la compra todos sus prodcutos
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source ="idCompra", target= "purchaseId"),
            @Mapping(source ="idCliente", target= "clientId"),
            @Mapping(source ="fecha", target= "date"),
            @Mapping(source ="medioPago", target= "paymentMethod"),
            @Mapping(source ="comentario", target= "comment"),
            @Mapping(source ="estado", target= "state"),
            @Mapping(source ="productos", target= "items"),
    })

    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchase(List<Compra>compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
