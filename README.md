# ProductManager
basit bir urun yonetim sistemi

## Usage:
```Java
public class Main {
    public static void main(String[] args) {
        // Database oluşturuluyor
        ProductManager productManager = new ProductManager();
        productManager.createTable();

        // Ürünler ekleniyor
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setPrice(1500.0);
        productManager.addProduct(product1);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setPrice(800.0);
        productManager.addProduct(product2);

        // Tüm ürünler listeleniyor
        System.out.println("All Products:");
        productManager.printAllProducts();
    }
}
```
