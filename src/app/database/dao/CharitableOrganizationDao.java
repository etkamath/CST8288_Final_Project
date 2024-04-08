package app.database.dao;

import app.model.Food;

import java.util.List;

public interface CharitableOrganizationDao {
    /**
     * Charitable Organizations can claim a food with its foodId and quantity
     * @param foodId
     * @param quantity
     * @return true if food is available else false
     * @throws IllegalArgumentException if quantity input is negative
     * @throws IndexOutOfBoundsException if input quantity is larger than selected food quantity
     */
    boolean claimFood(int foodId,int quantity) throws IllegalArgumentException,IndexOutOfBoundsException;

    /**
     * method to get donated foods
     * @returns foods with donation flag
     */
    List<Food> donatedFoods();
}
