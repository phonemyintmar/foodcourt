package mm.com.dagon.foodcourt.database.repo;

import mm.com.dagon.foodcourt.database.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuRepository extends MongoRepository<Menu, String> {

    List<Menu> findByShopId(String studentId);
}
