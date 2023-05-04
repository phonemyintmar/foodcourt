package mm.com.dagon.foodcourt.logic.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.dagon.foodcourt.database.model.Order;
import mm.com.dagon.foodcourt.database.model.Status;
import mm.com.dagon.foodcourt.database.repo.OrderRepository;
import mm.com.dagon.foodcourt.logic.IOrderService;
import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import mm.com.dagon.foodcourt.payload.response.OrderListForShopDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static mm.com.dagon.foodcourt.payload.response.ResponseFactory.*;

@Service
@Slf4j
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> makeOrder(MakeOrderRequest orderRequest) {
        Order order = new Order();
        order.setDishIds(orderRequest.getDishIds());
        order.setDishNames(orderRequest.getDishNames());
        order.setStudentId(orderRequest.getStudentId());
        order.setShopId(orderRequest.getShopId());
        order.setTotalCost(orderRequest.getTotalCost());
        order.setIsCustomAddress(orderRequest.getIsCustomAddress());
        order.setCustomAddress(orderRequest.getCustomAddress());
        order.setStatus(Status.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        try {
            orderRepository.save(order);
            return onSuccessWithMessage(null, "100", String.format("Ordered successfully for the dishes %s", orderRequest.getDishNames()));
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    @Override
    public ResponseEntity<?> getStudentOrder(String id, Pageable pageable) {
        try {
            Page<Order> orders = orderRepository.findByStudentId(id, pageable);
            return onSuccessWithMessage(orders, "000", "Orders data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }


    @Override
    public ResponseEntity<?> getOrdersFilteredForShop(LocalDateTime fromTime, LocalDateTime toTime, String shopId, String studentId, Pageable pageable) {
        try {
            Page<Order> ordersPage = orderRepository.findByShopIdAndStudentIdAndCreatedAtBetween(shopId, studentId, fromTime, toTime, pageable);
            Page<OrderListForShopDTO> page = ordersPage.map(order -> modelMapper.map(order, OrderListForShopDTO.class));
            return onSuccessWithMessage(page, "000", "Orders for shops fetched");
        } catch (Exception e) {
            return onFailWithMessage("122", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getOrdersFiltered(LocalDateTime fromTime, LocalDateTime toTime, String shopId, String studentId, Pageable pageable) {
        try {
            Page<Order> ordersPage = orderRepository.findByShopIdAndStudentIdAndCreatedAtBetween(shopId, studentId, fromTime, toTime, pageable);
            return onSuccessWithMessage(ordersPage, "000", "Orders for shops fetched");
        } catch (Exception e) {
            return onFailWithMessage("122", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getUnfinishedOrders(String shopId, Pageable pageable) {
        try {
            Page<Order> unfinishedOrdersPage = orderRepository.findByShopIdAndStatusIn(
                    shopId,
                    List.of(Status.PENDING.name(), Status.SENDING.name(), Status.PREPARING.name()),
                    pageable
            );
            Page<OrderListForShopDTO> page = unfinishedOrdersPage.map(order -> modelMapper.map(order, OrderListForShopDTO.class));
            return onSuccessWithMessage(page, "000", "Orders for shops fetched");
        } catch (Exception e) {
            return onFailWithMessage("122", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> changeOrderStatus(String orderId, Status status) {
        try {
            Order order = orderRepository.findById(orderId).orElse(null);
            if (order == null) return onFailWithMessage("104", "Cannot find the order with the id provided");
            order.setStatus(status);
            orderRepository.save(order);
            return onSuccessDefault(null);
        } catch (Exception e) {
            return onFailWithMessage("122", e.getMessage());
        }
    }


}

