package app.model;

public enum FoodFlag {
    NEARING_EXPIRATION(1),
    EXPIRED(2),
    EXCESS_OF_DEMAND(3),
    DONATION(4);
    private int code;

    FoodFlag(int code) {
        this.code = code;
    }

    public  static String getString(FoodFlag flag){
        switch (flag){
            case NEARING_EXPIRATION -> {return "Nearing Expiration";}
            case EXPIRED -> {return "Expired";}
            case EXCESS_OF_DEMAND -> {return "Excess of Demand";}
            case DONATION -> {return "Donation";}
            default -> {return "";}
        }
    }


    private FoodFlag(){}
}
