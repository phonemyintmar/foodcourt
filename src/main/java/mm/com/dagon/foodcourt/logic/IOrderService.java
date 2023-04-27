package mm.com.dagon.foodcourt.logic;

import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import org.springframework.http.ResponseEntity;

public interface IOrderService {
    ResponseEntity<?> makeOrder(MakeOrderRequest orderRequest);
}
