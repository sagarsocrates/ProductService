package com.example.productservice.controllers;

import com.example.productservice.commons.AuthenticationCommons;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.dtos.UserDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.exceptions.ProductControllerSpecificException;
import com.example.productservice.models.Product;
import com.example.productservice.models.Role;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    AuthenticationCommons authenticationCommons;

    ProductController(@Qualifier("selfProductService") ProductService productService, AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }
    //localhost:2020/prodcuts/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws InvalidProductIdException {

        Product product =  productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    //localhost:2020/prodcuts
//    @GetMapping("/all/{token}")
    @GetMapping("/")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam("pageNumber") int pageNumber,
                                                        @RequestParam("pageSize") int pageSize) {
        //Validate the token using UserService
//        UserDto userDto = authenticationCommons.validateToken(token);

//        if(userDto == null) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }

//        boolean isAdmin = false;
//        for(Role role : userDto.getRoles()) {
//            if(role.equals("ADMIN")){
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if(!isAdmin) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
        Page<Product> products = productService.getAllProducts(pageNumber, pageSize);
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }

    //create
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    //Partial Update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    //Replace Product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto product) {

        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleProductControllerSpecificException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
