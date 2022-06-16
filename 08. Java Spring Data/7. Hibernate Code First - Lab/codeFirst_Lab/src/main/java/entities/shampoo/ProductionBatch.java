package entities.shampoo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "bathces")
public class ProductionBatch {
    @Override
    public String toString() {
        return "ProductionBatch{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", shampoos=" + shampoos +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private LocalDate createdAt;

    @OneToMany(mappedBy = "batch", targetEntity = BasicShampoo.class
    ,fetch =FetchType.LAZY)
    private Set<BasicShampoo> shampoos;

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public ProductionBatch() {}

    public ProductionBatch(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
