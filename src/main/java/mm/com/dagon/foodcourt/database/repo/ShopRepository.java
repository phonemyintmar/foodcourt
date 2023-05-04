package mm.com.dagon.foodcourt.database.repo;

import mm.com.dagon.foodcourt.database.model.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Shop, String> {
}
