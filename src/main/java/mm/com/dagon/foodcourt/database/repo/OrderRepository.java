package mm.com.dagon.foodcourt.database.repo;

import mm.com.dagon.foodcourt.database.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    Page<Order> findByStudentId(String shopId, Pageable pageable);

    Page<Order> findByShopIdAndStudentIdAndCreatedAtBetween(String shopId, String studentId, LocalDateTime fromTime, LocalDateTime toTime, Pageable pageable);

    Page<Order> findByShopIdAndStatusIn(String shopId, List<String> status, Pageable pageable);


}
