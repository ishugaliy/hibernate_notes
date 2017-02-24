package hibernate.test.repository;

import hibernate.test.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 14.01.17
 *
 * @author Yuriy Shugaliy.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
