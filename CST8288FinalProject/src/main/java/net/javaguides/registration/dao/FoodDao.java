package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.FoodItem;

public class FoodDao {

    public void createFood(FoodItem food) {
        String sql = "INSERT INTO FoodItems (RetailerID, Name, Quantity, ExpiryDate, IsSurplus,discount) VALUES (?,?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, food.getRetailerID());
            statement.setString(2, food.getName());
            statement.setInt(3, food.getQuantity());
            statement.setDate(4, new java.sql.Date(food.getExpiryDate().getTime()));
            statement.setBoolean(5, food.isSurplus());
            statement.setDouble(6,food.getDiscount());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FoodItem findFoodById(int itemId) {
        FoodItem food = null;
        String sql = "SELECT * FROM FoodItems WHERE ItemID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, itemId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    food = new FoodItem();
                    food.setItemID(resultSet.getInt("ItemID"));
                    food.setRetailerID(resultSet.getInt("RetailerID"));
                    food.setName(resultSet.getString("Name"));
                    food.setQuantity(resultSet.getInt("Quantity"));
                    food.setExpiryDate(resultSet.getDate("ExpiryDate"));
                    food.setSurplus(resultSet.getBoolean("IsSurplus"));
                    food.setDiscount(resultSet.getDouble("discount"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return food;
    }

    public void updateFood(FoodItem food) {
        String sql = "UPDATE FoodItems SET RetailerID = ?, Name = ?, Quantity = ?, ExpiryDate = ?, IsSurplus = ?, discount= ? WHERE ItemID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, food.getRetailerID());
            statement.setString(2, food.getName());
            statement.setInt(3, food.getQuantity());
            statement.setDate(4, new java.sql.Date(food.getExpiryDate().getTime()));
            statement.setBoolean(5, food.isSurplus());
            statement.setDouble(6, food.getDiscount());
            statement.setInt(7, food.getItemID());

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFood(int itemId) {
        String sql = "DELETE FROM FoodItems WHERE ItemID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setItemID(resultSet.getInt("ItemID"));
                foodItem.setRetailerID(resultSet.getInt("RetailerID"));
                foodItem.setName(resultSet.getString("Name"));
                foodItem.setQuantity(resultSet.getInt("Quantity"));
                foodItem.setExpiryDate(resultSet.getDate("ExpiryDate"));
                foodItem.setSurplus(resultSet.getBoolean("IsSurplus"));
                foodItem.setDiscount(resultSet.getDouble("discount"));
                foodItems.add(foodItem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return foodItems;
    } public List<FoodItem> getAllFoodItemsForSale() {
        List<FoodItem> foodItems = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems  where IsSurplus=0";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setItemID(resultSet.getInt("ItemID"));
                foodItem.setRetailerID(resultSet.getInt("RetailerID"));
                foodItem.setName(resultSet.getString("Name"));
                foodItem.setQuantity(resultSet.getInt("Quantity"));
                foodItem.setExpiryDate(resultSet.getDate("ExpiryDate"));
                foodItem.setSurplus(resultSet.getBoolean("IsSurplus"));
                foodItem.setDiscount(resultSet.getDouble("discount"));
                foodItems.add(foodItem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return foodItems;
    }
    public List<FoodItem> getAllDonationFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems where IsSurplus=1 and discount=0";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setItemID(resultSet.getInt("ItemID"));
                foodItem.setRetailerID(resultSet.getInt("RetailerID"));
                foodItem.setName(resultSet.getString("Name"));
                foodItem.setQuantity(resultSet.getInt("Quantity"));
                foodItem.setExpiryDate(resultSet.getDate("ExpiryDate"));
                foodItem.setSurplus(resultSet.getBoolean("IsSurplus"));
                foodItem.setDiscount(resultSet.getDouble("discount"));
                foodItems.add(foodItem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return foodItems;
    }
}
