package app.panel;

import app.database.DatabaseSingleton;
import app.database.dao.CharitableOrganizationDao;
import app.model.CharitableOrganization;
import app.model.Food;

import java.util.List;

public class CharitableOrganizationPanel extends UserPanel<CharitableOrganization> {
    private CharitableOrganizationDao dao = DatabaseSingleton.getDatabase().charitableOrganizationDao();
    private List<Food> foodList = dao.donatedFoods();
    public CharitableOrganizationPanel(CharitableOrganization loggedIn) {
        super(loggedIn);

    }
    public void claimFood(int foodId,int quantity){
        dao.claimFood(foodId,quantity);
        updateFoodsList();
    }
    private void updateFoodsList(){
        foodList = dao.donatedFoods();
    }
    private List<Food> getFoodsList(){
        return foodList;
    }
}
