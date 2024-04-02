package app.database.implementation;

import app.database.dao.FoodDao;
import app.model.Food;

public class FoodDaoImpl implements FoodDao {
    @Override
    public Food findFoodById(int foodId) {
        //TODO: Query to find Foods by id
        return null;
    }

    @Override
    public boolean updateFood(Food food) {
        //TODO: Query to update foods information
        return false;
    }

    @Override
    public boolean setDiscount(int foodId, int discount) throws IllegalArgumentException {
        Food f = findFoodById(foodId);
        if(f==null)
            return false;
        //TODO: Query to update food discount
        return true;
    }
}
