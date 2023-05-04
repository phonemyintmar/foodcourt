package mm.com.dagon.foodcourt.logic;

import mm.com.dagon.foodcourt.database.model.Order;
import mm.com.dagon.foodcourt.database.model.Status;
import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface IOrderService {
    ResponseEntity<?> makeOrder(MakeOrderRequest orderRequest);

    ResponseEntity<?> getStudentOrder(String id, Pageable pageable);

    ResponseEntity<?> getOrdersFilteredForShop(LocalDateTime fromTime, LocalDateTime toTime, String shopId, String studentId, Pageable pageable);
    ResponseEntity<?> getOrdersFiltered(LocalDateTime fromTime, LocalDateTime toTime, String shopId, String studentId, Pageable pageable);

    ResponseEntity<?> getUnfinishedOrders(String shopId);

    ResponseEntity<?> changeOrderStatus(String orderId, Status status);
}
