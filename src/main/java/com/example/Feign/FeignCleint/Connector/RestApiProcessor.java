package com.example.Feign.FeignCleint.Connector;

import com.example.RESTAPI.ReafactoredRESTAPI.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient("RESTAPI")
public interface RestApiProcessor  {

    @RequestMapping(path="api/products/{id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable(value = "id") Integer Id);

}
