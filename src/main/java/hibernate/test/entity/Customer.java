package hibernate.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
 * Customer Entity - maps to CUSTOMER table
 */
@Getter
@Setter
@Entity(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "STREET")
    private String street;

    @Column(name = "APPT")
    private String appt;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Order> orders;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
