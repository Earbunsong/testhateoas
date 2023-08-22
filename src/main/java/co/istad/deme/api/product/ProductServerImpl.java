package co.istad.deme.api.product;

import co.istad.deme.api.product.web.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServerImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> listAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"id :"+id));
        return product;
    }
}
