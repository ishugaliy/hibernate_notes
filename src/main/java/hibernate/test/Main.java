package hibernate.test;

import hibernate.test.entity.Customer;
import hibernate.test.entity.Order;
import hibernate.test.entity.Product;
import hibernate.test.repository.CustomerRepository;
import hibernate.test.repository.OrderRepository;
import hibernate.test.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 14.01.17
 *
 * @author Yuriy Shugaliy.
 */
@RestController
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager et;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException {
        Order order = orderRepository.findOne(333L);
        int i = 4;
//        Session session = (Session) et.getDelegate();
//        session.isConnected()
//        Product product = productRepository.findOne(2000L);
//        product.getOrderList().remove(0);
//        productRepository.save(product);

//        orderRepository.delete(order);
//        Order order = customer.getOrders().remove(1);
//        order.setCustomer(null);
//        customerRepository.save(customer);
//        customerRepository.delete(100L);
//        Order removed = customer.getOrders().remove(1);
//        removed.setCustomer(null);
//        orderRepository.save(removed);
    }

    @RequestMapping
    public String test() {
        return "";
    }
}
