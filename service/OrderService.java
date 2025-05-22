package service;

import model.Order;
import model.Product;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private List<Order> orders;
    private Scanner scanner;
    private ProductService productService;

    public OrderService(ProductService productService) {
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.productService = productService;
    }

    public Order findOrderById(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    public boolean hasOrders() {
        if (orders.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return false;
        }
        return true;
    }

    public void addOrder() {

        Product product = null;

        while (product == null) {
            int productId = ValidationUtils.requestInteger("Ingresá el ID del producto a agregar al pedido: ", scanner);
            product = productService.findProductById(productId);
            if (product == null) {
                System.out.println("Producto no encontrado. Por favor, ingrese un ID válido.");
            }
        }

        int orderNumber;
        do {
            orderNumber = ValidationUtils.requestInteger("Ingresá el número de orden del pedido: ", scanner);
            if (findOrderById(orderNumber) != null) {
                System.out.println("Ya existe un pedido con ese número. Por favor, ingrese otro número.");
            }
        } while (findOrderById(orderNumber) != null);

        if (product.getStock() == 0) {
            System.out.println("No hay stock disponible para este producto.");
            return;
        }

        int quantity;
        do {
            quantity = ValidationUtils.requestInteger("Ingresá la cantidad del producto a agregar al pedido: ",
                    scanner);
            if (quantity > product.getStock()) {
                System.out.println(
                        "Stock insuficiente, solo pueden agregarse al pedido hasta " + product.getStock()
                                + " unidades.");
            }
        } while (quantity > product.getStock());

        Order newOrder = new Order(orderNumber, product, quantity);
        orders.add(newOrder);

        product.setStock(product.getStock() - quantity);

        System.out.println("Pedido creado correctamente.");
        newOrder.showOrderDetails();
    }

    public void listOrders() {
        if (hasOrders()) {
            System.out.println("Lista de pedidos:");
            for (Order order : orders) {
                order.showOrderDetails();
                ;
            }
        }
    }

    public void editOrder() {
        if (!hasOrders()) {
            return;
        }

        int orderNumber = ValidationUtils.requestInteger(null, scanner);

        Order orderToEdit = findOrderById(orderNumber);

        if (orderToEdit == null) {
            System.out.println("Pedido no encontrado en nuestros registros.");
            return;
        }

        System.out.println("Pedido encontrado:");
        orderToEdit.showOrderDetails();
        orderToEdit.setQuantity(ValidationUtils.requestInteger("Ingrese la nueva cantidad del pedido: ",
                scanner));
        System.out.println("Pedido editado correctamente.");

    }

    public void deleteOrder() {
        if (!hasOrders()) {
            return;
        }

        int orderNumber = ValidationUtils.requestInteger("Ingrese el número de orden del pedido a eliminar: ", scanner);
        Order orderToDelete = findOrderById(orderNumber);

        if (orderToDelete == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        orders.remove(orderToDelete);
        System.out.println("Pedido eliminado correctamente.");
        listOrders();
    }
}
