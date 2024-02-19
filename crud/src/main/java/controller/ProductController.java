package controller;

import entity.Product;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.ProductService;

import java.util.List;

@Path("/product")
public class ProductController {

    private ProductService productService;

    @Inject
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> find() {
        return productService.getProducts();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Product create(Product product){
        return productService.addProduct(product);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product update(String id, Product product){
        return productService.changeProducts(id, product);
    }

    @DELETE
    @Path("/{id}")
    public String delete(String id){
        return productService.deleteProducts(id);
    }
}
