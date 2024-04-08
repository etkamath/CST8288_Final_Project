package app.database.dao;

import app.model.Food;

public interface FoodDao {
    /**
     * Finds Food By Id and return selected Food and returns its data in Shape of Food class Object
     * @param foodId
     * @returns Food if available else returns null
     */
    Food findFoodById(int foodId);

    /**
     * flag food as nearing expiration, expired, excess of demand or flag for donation
     * @param foodId
     * @param flag
     * @returns true if food Is Available
     */
    /**
     * update specified food with new values that stored in input parameter
     * @param food
     * @returns true if food id is availabale and all fields are updated with new values
     */
    boolean updateFood(Food food);

    /**
     * add discount to foods
     * @param foodId
     * @param discount
     * @return true if food with this id is available else returns false
     * @throws IllegalArgumentException if discount is out of [0 ... 100] range
     */
    boolean setDiscount(int foodId, int discount) throws IllegalArgumentException;

}
