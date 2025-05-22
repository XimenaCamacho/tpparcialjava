package menu;

import java.util.Scanner;
import service.ProductService;
import service.OrderService;

public class MainMenu {
    private Scanner scanner;
    private ProductService productService;
    private OrderService orderService;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.productService = new ProductService();
        this.orderService = new OrderService(productService);
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                productService.addProduct();
                break;
            case 2:
                productService.listProducts();
                break;
            case 3:
                productService.editProduct();
                break;
            case 4:
                System.out.println("Entramos al 4!! WIIIII Al fin");
                productService.deleteProduct();
                break;
            case 5:
                System.out.println("Entramos al 5");
                orderService.addOrder();
                break;
            case 6:
                System.out.println("Entramos al 6");
                orderService.listOrders();
                break;
            case 7:
                System.out.println("Entramos al 7");
                orderService.editOrder();
                break;
            case 8:
                System.out.println("Entramos al 8");
                orderService.deleteOrder();
                break;
            case 0:
                System.out.println("Saliendo de la aplicación.");
                scanner.close();
                break;
            default:
                System.out.println("Opción no válida. Volvé a ingresar una opción.");
        }
    }

    public void ShowMenu() {
        int option = -1;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar un producto.");
            System.out.println("2. Listar todos productos.");
            System.out.println("3. Editar un producto.");
            System.out.println("4. Eliminar un producto.");
            System.out.println("5. Generar un pedido.");
            System.out.println("6. Listar todos los pedidos.");
            System.out.println("7. Editar un pedido.");
            System.out.println("8. Eliminar un pedido.");
            System.out.println("0. Salir.");
            System.out.print("Seleccione una opción: ");
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                processOption(option);
            } catch (Exception e) {
                System.out.println("Opción no válida. Volvé a ingresar una opción.");
                e.printStackTrace();
                scanner.nextLine();
            }
        } while (option != 0);
    }
}
