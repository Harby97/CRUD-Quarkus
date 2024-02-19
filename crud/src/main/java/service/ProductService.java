package service;

import entity.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductService {
    List<Product> products;
    public ProductService() {
        this.products = new ArrayList<>();
        generate();
    }

    private void generate(){
        products.add(new Product("7bf66cc9-bd8d-4dc3-948f-59ba26d892c3", "bandeja paisa", "20000"));
        products.add(new Product("2a6cca3c-43ca-4019-ab62-72a0912b5859", "sancocho", "15000"));
        products.add(new Product("d9c58f5e-191e-4826-9e22-e70927fd18a7", "cahngua", "12000"));
    }

    public Product addProduct(Product product) {
        this.products.add(product);
        return  product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product changeProducts(String id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            String posibleMatch = products.get(i).id;
            if (product.getId().equals(posibleMatch)) {
                System.out.println("coincidencia");
                products.set(i, product);
                return product;
            }
        }
        return product;
    }

    public String deleteProducts(String id) {
        for (int i = 0; i < products.size(); i++) {
            String posibleMatch = products.get(i).id;
            if (id.equals(posibleMatch)) {
                products.remove(i);
            }
        }
        return id;
    }
}
