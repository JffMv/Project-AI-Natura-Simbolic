package com.ai.prolog.natura.api_ai_prolog.controller;
import com.ai.prolog.natura.api_ai_prolog.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/api")
public class AIcontroller {

    @PostMapping("/product")
    @ResponseBody
    public ResponseEntity<String> getProduct(Product product){
        product.process();
        String productName = product.getName();
        return new ResponseEntity<>("{\"productName\": \"" + productName + "\"}", HttpStatus.ACCEPTED);
    }
}
