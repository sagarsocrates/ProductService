package com.example.productservice.services;

import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service ("selfProductService")
//@Primary
//=> This annotation can be use only if we need to give high priority to a single service
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //Optional is used for safety, if the returned value is null, we might get
        // null pointer exception, if we mark it optional, it will give us a warning
        // that it could be null, we are supposed to handle that case
        Optional<Product> optionalProduct =  productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductIdException(id, "Invalid Product Id");
        }
        return optionalProduct.get();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber, pageSize,Sort.by("price").descending()));
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        if(product == null) throw new RuntimeException("Product cannot be null");

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) throw new RuntimeException("Product not found");

        Product currentProduct = optionalProduct.get();

        if(product.getTitle() != null){
            currentProduct.setTitle(product.getTitle());
        }

        if(product.getDescription() != null){
            currentProduct.setDescription(product.getDescription());
        }
        return productRepository.save(currentProduct);
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            //first sve category in db
            Category saveCategory = categoryRepository.save(category);
            product.setCategory(saveCategory);
        }
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new RuntimeException("Product not found");
        Product currentProduct = optionalProduct.get();
        currentProduct.setTitle(productDto.getTitle());
        currentProduct.setDescription(productDto.getDescription());
        currentProduct.setImage(productDto.getImage());
        currentProduct.setPrice(productDto.getPrice());

        Optional<Category> currentCategory = categoryRepository.findById(productDto.getId());
        if(currentCategory.isPresent()){
            currentProduct.setCategory(currentCategory.get());
        }
        return productRepository.save(currentProduct);

    }

    @Override
    public void deleteProduct(Long id) {
            productRepository.deleteById(id);
    }
}
