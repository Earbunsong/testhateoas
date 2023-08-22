package co.istad.deme.api.product.web;

import co.istad.deme.api.product.Product;
import co.istad.deme.api.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<?> productAll() {
        List<Product> products = productService.listAll();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        for (Product product : products) {
            product.add(linkTo(methodOn(ProductController.class).productGetById(product.getId())).withSelfRel());
        }


        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> productGetById(@PathVariable("id") Long id) {


        Product product = productService.getById(id);

        product.add(linkTo(methodOn(ProductController.class).productGetById(product.getId())).withRel("product_id"));
        product.add(linkTo(ProductController.class).slash(product.getId()).withSelfRel());


        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
