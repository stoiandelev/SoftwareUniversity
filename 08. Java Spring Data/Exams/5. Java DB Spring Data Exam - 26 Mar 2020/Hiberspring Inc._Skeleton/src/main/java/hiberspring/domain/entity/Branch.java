package hiberspring.domain.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne()
    private Town town;

    @OneToMany(mappedBy = "branch")
    private Set<Product> products;



    public Branch() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
