import entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceTest {
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    public void addProductTest(){
        // Tamaño inicial del array
        int initialSize = productService.getProducts().size();

        // Producto a agregar
        Product newProduct = new Product("c2194f72-3d47-42ce-85ee-da58479c45dd", "Cocido boyacense", "30000");
        // Agregar el producto
        productService.addProduct(newProduct);

        // Tamaño del array después de agregar el producto
        int newSize = productService.getProducts().size();

        // Verificar que el tamaño del array ha aumentado en 1
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void testGetProductsNotNull() {
        // Obtener la lista de productos
        List<Product> productList = productService.getProducts();

        // Verificar que la lista no sea nula
        assertNotNull(productList);
    }

    @Test
    void testGetProductsSize() {
        // Obtener la lista de productos
        List<Product> productList = productService.getProducts();

        // Verificar que la lista tenga el tamaño esperado
        assertEquals(3, productList.size());
    }


    @Test
    void testGetProductsIds() {
        // Obtener la lista de productos
        List<Product> productList = productService.getProducts();

        // Verificar los IDs de los productos
        for (Product product : productList) {
            String id = product.getId();
            switch (id) {
                case "7bf66cc9-bd8d-4dc3-948f-59ba26d892c3":
                case "2a6cca3c-43ca-4019-ab62-72a0912b5859":
                case "d9c58f5e-191e-4826-9e22-e70927fd18a7":
                    break;
                default:
                    // Si el ID no coincide con ninguno de los esperados, falla la prueba
                    throw new AssertionError("ID de producto inesperado: " + id);
            }
        }
    }

    @Test
    public void updateTest(){
        Product newProduct = new Product("c2194f72-3d47-42ce-85ee-da58479c45dd", "Cocido boyacense", "30000");
        // Agregar el producto
        Product ChangedProduct = productService.changeProducts("7bf66cc9-bd8d-4dc3-948f-59ba26d892c3", newProduct);

        assertEquals(newProduct, ChangedProduct);
    }


}
