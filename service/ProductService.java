package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.ValidationUtils;// traigo las validaciones de utils

public class ProductService {
    private List<Product> products;
    private Scanner scanner;

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean hasProducts() {
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return false;
        }
        return true;
    }

    public ProductService() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addProduct() {
        int id;
        do {
            id = ValidationUtils.requestInteger("Ingrese el ID del producto: ", scanner);
            if (findProductById(id) != null) {
                System.out.println("Ya existe un producto con ese ID. Volvé a intentarlo con otro ID.");
            }
        } while (findProductById(id) != null);

        String name = ValidationUtils.requestName("Ingrese el nombre del producto: ", scanner);
        double price = ValidationUtils.requestDouble("Ingrese el precio del producto: ", scanner);
        int stock = ValidationUtils.requestInteger("Ingrese el stock del producto: ", scanner);

        Product newProduct = new Product(id, name, price, stock);
        products.add(newProduct);

        System.out.println("Producto agregado exitosamente.");
    }

    public void listProducts() {
        if (hasProducts()) {
            System.out.println("Lista de productos:");
            for (Product product : products) {
                product.showDetails();
            }
        }
    }

    public void editProduct() {

        if (!hasProducts()) {
            return;
        }
        int id = ValidationUtils.requestInteger("Ingrese el ID del producto a editar: ", scanner);
        Product productToEdit = findProductById(id);

        if (productToEdit == null) {
            System.out.println("Producto no encontrado en nuestros registros.");
            return;
        }
        System.out.println("Producto encontrado:");
        productToEdit.showDetails();
        productToEdit.setName(ValidationUtils.requestName("Ingrese el nuevo nombre del producto: ", scanner));
        productToEdit.setPrice(ValidationUtils.requestDouble("Ingrese el nuevo precio del producto: ", scanner));
        productToEdit.setStock(ValidationUtils.requestInteger("Ingrese el nuevo stock del producto: ", scanner));
        System.out.println("Producto editado exitosamente.");
    }

    public void deleteProduct() {
        if (!hasProducts()) {
            return;
        }
        int id = ValidationUtils.requestInteger("Ingrese el ID del producto a eliminar: ", scanner);
        Product productToDelete = findProductById(id);

        if (productToDelete == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        products.remove(productToDelete);
        System.out.println("Producto eliminado exitosamente.");
        listProducts();
    }
}