package model.fulvaz;

/**
 * Created by fulvaz on 16/10/7.
 */
public class Borrow {
    private String location;
    private String index;
    private String status;

    public Borrow(String index, String status, String location) {
        this.index = index;
        this.status = status;
        this.location = location;
    }

}
