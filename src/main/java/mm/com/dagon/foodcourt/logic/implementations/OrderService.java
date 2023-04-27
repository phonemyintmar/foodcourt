package mm.com.dagon.foodcourt.logic.implementations;

import mm.com.dagon.foodcourt.logic.IOrderService;
import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    private final MongoTemplate mongoTemplate;

    public OrderService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ResponseEntity<?> makeOrder(MakeOrderRequest orderRequest) {

        return null;
    }
}
