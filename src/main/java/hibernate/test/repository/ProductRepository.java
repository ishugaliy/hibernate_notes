package hibernate.test.repository;

import hibernate.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 14.01.17
 *
 * @author Yuriy Shugaliy.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
