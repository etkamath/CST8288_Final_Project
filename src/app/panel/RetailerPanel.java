package app.panel;

import app.database.dao.FoodDao;
import app.database.dao.NotificationDao;
import app.database.dao.RetailerDao;
import app.model.Food;
import app.model.FoodFlag;
import app.model.Retailer;

public class RetailerPanel extends UserPanel<Retailer> {
    RetailerDao retailerDao = super.getDataBase().retailerDao();
    private NotificationDao<String> notificationDao = super.getDataBase().notificationDao();
    private FoodDao foodDao = super.getDataBase().foodDao();
    public RetailerPanel(Retailer loggedIn) {
        super(loggedIn);
    }
    public boolean flagFood(int foodId, FoodFlag flag){
        Food selectedFood = foodDao.findFoodById(foodId);
        if(retailerDao.flagSurplusFood(foodId,flag)){
            notificationDao.notifyAllSubscribers("Food With ID: "+foodId+" status: "+FoodFlag.getString(flag));
            return true;
        }else{
            return false;
        }
    }
}
