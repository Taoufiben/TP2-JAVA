package ma.enset.hospitaal.repositories;

import ma.enset.hospitaal.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
