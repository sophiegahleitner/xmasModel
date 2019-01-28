package im430.xmas.business;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private Set<Gift> gifts;
    
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Child() {
        this.id = -1;
        this.name = "";
        this.address = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(name, child.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Gift> getGifts() {
        if (this.gifts == null) this.gifts = new HashSet<Gift>();
        return this.gifts;
    }

    public void setGifts(Set<Gift> gifts) {
        this.gifts = gifts;
    }

    public void addGift(Gift g) {
        g.setChild(this);
        getGifts().add(g);
    }

    public void removeGift(Gift g) {
        if (getGifts().contains(g)) {
            g.setChild(null);
            getGifts().remove(g);
        }
    }
}
