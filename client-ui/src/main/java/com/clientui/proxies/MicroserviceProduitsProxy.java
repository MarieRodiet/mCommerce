package com.clientui.proxies;

import com.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
* interface qui va regrouper les requêtes que nous souhaitons passer au Microservice-produits. Cette interface est ce que nous appelons un proxy,
* car elle se positionne comme une classe intermédiaire qui fait le lien avec les microservices extérieurs à appeler.*/
@FeignClient(name = "microservice-produits", url = "localhost:9001")
@Component
public interface MicroserviceProduitsProxy {
    @GetMapping(value = "/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}
