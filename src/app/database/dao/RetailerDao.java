package app.database.dao;

import app.model.Food;
import app.model.FoodFlag;

import java.util.List;

/**
 * in this dao, retailers have access to manage inventory
 */
public interface RetailerDao {

    /**
     * Retailer Can add Food to foods table
     * @param f
     */
    void addFood(Food f);

    /**
     * updates Food Quantity with newQuantity
     * @param foodId
     * @param newQuantity
     * @return false if foodId is not valid
     * @throws IllegalArgumentException if newQuantity is negative
     */
    boolean updateFoodQuantity(int foodId, int newQuantity) throws IllegalArgumentException;

    /**
     * Increases quantity of specified food by one
     * @param foodId
     * @return true if foodId is available else false
     */
    boolean increaseQuantity(int foodId);

    /**
     * Decreases quantity of specified food by one
     * @param foodId
     * @return true if foodId is available else false
     */
    boolean decreaseFoodId(int foodId);


    boolean flagSurplusFood(int foodId, FoodFlag flag);



}
