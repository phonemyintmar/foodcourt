package mm.com.dagon.foodcourt.controller;

import mm.com.dagon.foodcourt.database.model.Status;
import mm.com.dagon.foodcourt.logic.IMenuService;
import mm.com.dagon.foodcourt.logic.IOrderService;
import mm.com.dagon.foodcourt.logic.IShopService;
import mm.com.dagon.foodcourt.payload.request.MenuCreateDTO;
import mm.com.dagon.foodcourt.payload.request.MenuUpdateDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mm.com.dagon.foodcourt.payload.request.ShopCreateDTO;
import mm.com.dagon.foodcourt.payload.request.ShopUpdateDTO;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
//@CrossOrigin
@RequestMapping("/shop")
public class ShopContoller {

    private final IShopService shopService;

    private final IMenuService menuService;

    private final IOrderService orderService;

    public ShopContoller(IShopService shopService, IMenuService menuService, IOrderService orderService) {
        this.shopService = shopService;
        this.menuService = menuService;
        this.orderService = orderService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createShop(@RequestBody @Valid ShopCreateDTO createDto) {
        return shopService.createShop(createDto);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getShopList() {
        return shopService.getAllShops();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getShopDetail(@PathVariable String id) {
        return shopService.getShopById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateShop(@PathVariable String id, @RequestBody @Valid ShopUpdateDTO updateDTO) throws Exception {
        return shopService.updateShop(id, updateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable String id) {
        return shopService.deleteShop(id);
    }


    @PostMapping("/dish/create")
    //real app mhr so yin principal ka userId nae menucreateDto ka shopId nae ko sit thint tl
    public ResponseEntity<?> createDish(@RequestBody @Valid MenuCreateDTO createDto) {
        return menuService.createMenu(createDto);
    }


    @GetMapping("/dish/list/{id}")
    public ResponseEntity<?> getDishListOfShop(@PathVariable String id) {
        return menuService.getAllMenusForOneShop(id);
    }

    @GetMapping("/dish/details/{id}")
    public ResponseEntity<?> getDishDetails(@PathVariable String id) {
        return menuService.getMenuById(id);
    }


    @PostMapping("/dish/update/{id}")
    public ResponseEntity<?> updateDish(@PathVariable String id, @RequestBody @Valid MenuUpdateDTO updateDTO) throws Exception {
        return menuService.updateMenu(id, updateDTO);
    }

    @DeleteMapping("/dish/remove/{id}")
    public ResponseEntity<?> removeDish(@PathVariable String id) {
        return menuService.deleteMenu(id);
    }


    @GetMapping("/getOrders/{shopId}")
    public ResponseEntity<?> getOrders(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fromTime,
                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime toTime,
                                       @PathVariable String shopId,
                                       @RequestParam(required = false) String student,
                                       @PageableDefault Pageable pageable) {
        return orderService.getOrdersFilteredForShop(fromTime, toTime, shopId, student, pageable);
    }

    @GetMapping("/getUnfinished/{id}")
    public ResponseEntity<?> getUnfinishedOrders(@PathVariable String id, @PageableDefault Pageable pageable) {
        return orderService.getUnfinishedOrders(id, pageable);
    }

    //dr myo twy so yin ll authentication sit thint instead of letting an orderId changing status
    @PutMapping("/finish/{orderId}")
    public ResponseEntity<?> markOrderFinished(@PathVariable String orderId, @RequestParam Status status) {
        return orderService.changeOrderStatus(orderId, status);
    }
}
