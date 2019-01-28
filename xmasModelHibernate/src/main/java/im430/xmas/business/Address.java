package im430.xmas.business;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Child> children;

    public Address() {
        this.id = -1;
        this.text = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(text, address.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Child> getChildren() {
        if (this.children == null) this.children = new HashSet<Child>();
        return this.children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public void addChild(Child c) {
        c.setAddress(this);
        getChildren().add(c);
    }

    public void removeChild(Child c) {
        if (getChildren().contains(c)) {
            c.setAddress(null);
            getChildren().remove(c);
        }
    }
}
