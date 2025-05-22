package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.name = nombre;
        this.price = precio;
        this.stock = stock;
    }

    // getters y setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void showDetails() {
        System.out.println("ID: " + this.id + " === Nombre: " + this.name + " === Precio: $" + this.price
                + " === Stock: " + this.stock + (stock == 0 ? " (Sin stock)" : ""));
    }
}
