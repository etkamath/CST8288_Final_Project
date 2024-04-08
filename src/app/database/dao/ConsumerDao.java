package app.database.dao;

import app.model.Consumer;

public interface ConsumerDao {
    /**
     * Consumers Can buy food
     * @param consumerId
     * @param foodId
     * @return
     * @throws IllegalArgumentException if quantity is larger th
     */
    boolean buyFood(int consumerId, int foodId, int quantity) throws IllegalArgumentException;

    Consumer findConsumerById(int consumerId);

    /**
     *
     * @param consumerId
     * @param balance
     * @return
     * @throws IllegalArgumentException if balance is negative
     */
    boolean addToConsumerBalance(int consumerId,int balance) throws IllegalArgumentException;
}
