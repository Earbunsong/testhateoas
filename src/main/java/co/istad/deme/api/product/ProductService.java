package co.istad.deme.api.product;

import java.util.List;

public interface ProductService{
    List<Product> listAll();
    Product getById(Long id);
}
