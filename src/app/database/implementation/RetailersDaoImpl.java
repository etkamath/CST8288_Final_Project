package app.database.implementation;

import app.database.dao.RetailerDao;
import app.model.Food;
import app.model.FoodFlag;

public class RetailersDaoImpl implements RetailerDao {
    @Override
    public void addFood(Food f) {
        //TODO: Query to add food to database
    }

    @Override
    public boolean updateFoodQuantity(int foodId, int newQuantity) throws IllegalArgumentException {
        if(newQuantity<0){
            throw new IllegalArgumentException("Quantity should not be less than zero");
        }
        //TODO: Query to update food quantity
        return true;
    }

    @Override
    public boolean increaseQuantity(int foodId) {
        //TODO: Query to increase quantity of a food
        return false;
    }

    @Override
    public boolean decreaseFoodId(int foodId) {
        //TODO: Query to decrease quantity of a food
        return false;
    }

    @Override
    public boolean flagSurplusFood(int foodId, FoodFlag flag) {
        //TODO: Query to flag a specified Food
        return false;
    }




}
