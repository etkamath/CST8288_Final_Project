package app.database.implementation;

import app.database.DataBase;
import app.database.DatabaseSingleton;
import app.database.dao.ConsumerDao;
import app.model.Consumer;
import app.model.Food;

public class ConsumerDaoImpl implements ConsumerDao {
    private DataBase db = DatabaseSingleton.getDatabase();
    @Override
    public Consumer findConsumerById(int consumerId) {
        //TODO: Query To Find Consumer
        return null;
    }

    @Override
    public boolean addToConsumerBalance(int consumerId, int balance) throws IllegalArgumentException {
        if(balance<0) {
            throw new IllegalArgumentException("Balance is Negative!");
        }

        //TODO: Query to Select Consumer and update his/her balance
        return true;
    }

    @Override
    public boolean buyFood(int consumerId, int foodId,int quantity) throws IllegalArgumentException {
        Food f = db.foodDao().findFoodById(foodId);
        Consumer c = findConsumerById(consumerId);
        int foodPrice = f.getPrice() - f.getPrice()*f.getDiscount();
        if(c.getBalance()<foodId)
            return false;

        //TODO: Query to update consumer new balance after buying food
        return true;
    }
}
