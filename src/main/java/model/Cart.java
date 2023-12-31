package model;

import jakarta.persistence.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private int id;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LineItem> lineItems = new ArrayList<LineItem>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Cart() {

    }

    public Cart(int id, List<LineItem> lineItems, User user) {
        this.id = id;
        this.lineItems = lineItems;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart(User user) {
        this.user = user;
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public void updateLineItem(LineItem lineItem, int quantity){
        int code = lineItem.getProduct().getId();
        for (int i = 0; i < this.lineItems.size(); i++) {
            if (lineItems.get(i).getProduct().getId() == code) {
                lineItems.get(i).setQuantity(quantity);
                return;
            }
        }
    }

    public void updateChooseLineItem(LineItem lineItem, boolean choose){
        int code = lineItem.getProduct().getId();
        for (int i = 0; i < this.lineItems.size(); i++) {
            if (lineItems.get(i).getProduct().getId() == code) {
                lineItems.get(i).setChoose(choose);
                System.out.println(lineItems.get(i).isChoose());
                return;
            }
        }
    }

    public int getQuantityItem (LineItem lineItem){
        int product_id = lineItem.getProduct().getId();
        for (int i = 0; i < lineItems.size(); i++) {
            LineItem lineItem_temp = lineItems.get(i);
            if (lineItem_temp.getProduct().getId() == product_id) {
                return lineItem_temp.getQuantity();
            }
        }
        return -1;
    }

    public void removeLineItem(LineItem lineItem) {
        int product_id = lineItem.getProduct().getId();
        for (int i = 0; i < lineItems.size(); i++) {
            LineItem lineItem_temp = lineItems.get(i);
            if (lineItem_temp.getProduct().getId()==product_id) {
                lineItems.remove(i);
                return;
            }
        }
    }
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < lineItems.size(); i++) {
//            if (lineItems.get(i).isChoose())
            total += lineItems.get(i).getTotal();
        }
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(this.getTotal());
    }
}