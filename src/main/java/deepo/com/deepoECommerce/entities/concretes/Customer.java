package deepo.com.deepoECommerce.entities.concretes;

public class Customer {
    private int costumer_id;
    private String email;
    private String password;
    public Customer() {
        super();
    }

    public Customer(int costumer_id, String email, String password) {
        this.costumer_id = costumer_id;
        this.email = email;
        this.password = password;
    }

    public int getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(int costumer_id) {
        this.costumer_id = costumer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
