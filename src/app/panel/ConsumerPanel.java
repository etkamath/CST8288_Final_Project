package app.panel;

import app.database.dao.ConsumerDao;
import app.model.Consumer;

public class ConsumerPanel extends UserPanel<Consumer> {
    private ConsumerDao dao = super.getDataBase().consumerDao();

    public ConsumerPanel(Consumer loggedIn) {
        super(loggedIn);
    }
    public boolean buyFood(int foodId,int foodQuantity){
        boolean result = dao.buyFood(super.getLoggedIn().getId(),foodId,foodQuantity);
        return result;
    }
    public void unsubscribe(){
        super.getDataBase().userDao().unsubscribe(getLoggedIn().getId());
    }
    public void subscribe(){
        super.getDataBase().userDao().subscribe(getLoggedIn().getId());
    }

}
