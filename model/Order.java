package model;

public class Order {
    private int orderNumber;
    Product product;
    private int quantity;

    public Order(int orderNumber, Product product, int quantity) {
        this.orderNumber = orderNumber;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void showOrderDetails() {
        System.out.println("Pedido N°:" + orderNumber + " == ID Producto: " + product.getId() +
                " == Nombre Producto: " + product.getName() + " == Cantidad: " + quantity);
    }

}