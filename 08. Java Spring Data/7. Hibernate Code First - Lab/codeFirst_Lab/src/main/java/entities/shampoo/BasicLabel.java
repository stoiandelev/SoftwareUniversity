package entities.shampoo;


import javax.persistence.*;

@Entity
@Table(name = "labels")
public class BasicLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String color;

    public BasicShampoo getShampoo() {
        return shampoo;
    }

    public void setShampoo(BasicShampoo shampoo) {
        this.shampoo = shampoo;
    }

    @OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class)
    private BasicShampoo shampoo;


    public BasicLabel() {}
    public BasicLabel(String color) {
        this.color = color;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
