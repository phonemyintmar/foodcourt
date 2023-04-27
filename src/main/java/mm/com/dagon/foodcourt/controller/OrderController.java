package mm.com.dagon.foodcourt.controller;

import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @PostMapping("makeOrder")
    public ResponseEntity<?> makeOrder(@RequestBody MakeOrderRequest orderRequest) {

        return null;
    }
}
