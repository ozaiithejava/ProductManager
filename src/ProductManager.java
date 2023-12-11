import java.sql.*;

public class ProductManager {
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS products (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "price REAL NOT NULL" +
                    ")";

    private static final String INSERT_PRODUCT_QUERY =
            "INSERT INTO products (name, price) VALUES (?, ?)";

    private static final String SELECT_ALL_PRODUCTS_QUERY =
            "SELECT * FROM products";

    public void createTable() {
        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_QUERY)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllProducts() {
        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS_QUERY)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                System.out.println("Product ID: " + id + ", Name: " + name + ", Price: " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
