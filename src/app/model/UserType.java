package app.model;

public enum UserType {
    RETAILERS(1),
    CONSUMERS(2),
    CHARITABLE_ORGANIZATIONS(3);

    private int code;
    UserType(int code){
        this.code = code;
    }


    /**
     * <p>
     * it is used to get code of user type so we can use it to store user type
     * in database.
     * </p>
     *
     * @return code
     */
    public int getCode(){
        return code;
    }
}
