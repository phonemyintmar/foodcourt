package mm.com.dagon.foodcourt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("/shop")
public class ShopContoller {

    @GetMapping("/unfinishedOrders")
    public ResponseEntity<?> unfinishedOrders() {
        return null;
    }

    @PostMapping("/order/finish/{id}")
    public ResponseEntity<?> markFinished(@PathVariable String id) {
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShop() {
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getShopList() {
        return null;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getShopDetail(@PathVariable String id) {
        return null;
    }


    @PostMapping("/update")
    public ResponseEntity<?> updateShop() {
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteShop() {
        return null;
    }

    @PostMapping("/dish/create")
    public ResponseEntity<?> createDish() {
        return null;
    }

    @GetMapping("/dish/list")
    public ResponseEntity<?> getDishListOfShop() {
        return null;
    }

    @GetMapping("/dish/details/{id}")
    public ResponseEntity<?> getDishDetails(@PathVariable String id) {
        return null;
    }


    @PostMapping("/dish/update")
    public ResponseEntity<?> updateDish() {
        return null;
    }

    @DeleteMapping("/dish/remove")
    public ResponseEntity<?> removeDish() {
        return null;
    }
}
