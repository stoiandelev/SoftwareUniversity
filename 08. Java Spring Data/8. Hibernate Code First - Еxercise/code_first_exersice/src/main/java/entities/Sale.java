package entities;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    //product_id, customer_id, store_location_id, date

    //•	Sale has one product and a product can be sold in many sales
    @ManyToOne
    private Product product;

    //•	Sale has one customer and a customer can participate in many sales
    @ManyToOne
    private Customer customer;

    //•	Sale has one store location and one store location can have many sales
    @ManyToOne
    private StoreLocation storeLocation;

    @Column(name = "date")
    private LocalDateTime dateTime;

    public Sale() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
