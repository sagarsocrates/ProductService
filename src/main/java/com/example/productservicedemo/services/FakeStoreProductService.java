package com.example.productservicedemo.services;

import com.example.productservicedemo.dtos.ProductDto;
import com.example.productservicedemo.exceptions.InvalidProductIdException;
import com.example.productservicedemo.models.Category;
import com.example.productservicedemo.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());

        Category category = new Category();
        category.setTitle(productDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //call fakestore api to get product with given ID.
        ProductDto productDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDto.class);

        if(productDto == null) {
            throw new InvalidProductIdException(id, "Invalid Product Id passed");
        }
        //convert fakeStoreProductDto to product object.
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {

        ProductDto[] productDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        if(productDtos == null) {
            return null;
        }

        ArrayList<Product> products = new ArrayList<>();
        for(ProductDto productDto : productDtos) {
            products.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, ProductDto product) {
        //we do not have the direct put method in resttemplate that will return something, there
        //return type is void, hence we are implementing it ourself, ultimately the call is going to execute method
        // so we are trying to adjust the parameters four our need and call the execute method of restTemplate class.
        // see class Day 196 - Backend Projects: Nuances Wrt ApI's And Response Entity after 1 hour timestamp to understand

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor = new HttpMessageConverterExtractor(ProductDto.class, restTemplate.getMessageConverters());
        ProductDto productDto =  restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback,responseExtractor);

        if(productDto == null) {
            return null;
        }
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
