package app.database.implementation;

import app.database.DataBase;
import app.database.DatabaseSingleton;
import app.database.dao.CharitableOrganizationDao;
import app.model.Food;

import java.util.List;

public class CharitableOrganizationDaoImpl implements CharitableOrganizationDao {
    private DataBase db = DatabaseSingleton.getDatabase();
    @Override
    public boolean claimFood(int foodId, int quantity) throws IllegalArgumentException, IndexOutOfBoundsException {
        Food f = db.foodDao().findFoodById(foodId);
        if(quantity>f.getQuantity()){
            throw new IndexOutOfBoundsException("Input Quantity is Larger than food real Quantity");
        }else if(quantity<=0){
            throw new IllegalArgumentException("Quantity is Negative or Equal To Zero!");
        }

        return db.retailerDao().updateFoodQuantity(f.getId(),f.getQuantity()-quantity);

    }

    @Override
    public List<Food> donatedFoods() {
        //TODO: QUERY To get donated Foods
        return null;
    }
}
