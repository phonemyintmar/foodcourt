package mm.com.dagon.foodcourt.controller;

import mm.com.dagon.foodcourt.database.model.Status;
import mm.com.dagon.foodcourt.logic.IMenuService;
import mm.com.dagon.foodcourt.logic.IOrderService;
import mm.com.dagon.foodcourt.logic.IShopService;
import mm.com.dagon.foodcourt.logic.IStudentService;
import mm.com.dagon.foodcourt.payload.request.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    private final IStudentService studentService;

    private final IShopService shopService;

    private final IMenuService menuService;

    private final IOrderService orderService;

    public AdminController(IStudentService studentService, IShopService shopService, IMenuService menuService, IOrderService orderService) {
        this.studentService = studentService;
        this.shopService = shopService;
        this.menuService = menuService;
        this.orderService = orderService;
    }


    // Student CRUD
    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentCreateDTO studentCreateDTO) {
        return studentService.createStudent(studentCreateDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getStudentList() {
        return studentService.getAllStudents();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getStudentDetail(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody @Valid StudentUpdateDTO updateDTO) throws Exception {
        return studentService.updateStudent(id, updateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    //    Shop CRUD
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


    //   Menu CRUD
    @PostMapping("/dish/create")
    //real app mhr so yin principal ka userId nae menucreateDto ka shopId nae ko sit thint tl
    public ResponseEntity<?> createDish(@RequestBody @Valid MenuCreateDTO createDto) {
        return menuService.createMenu(createDto);
    }


    @GetMapping("/dish/list/")
    public ResponseEntity<?> getDishListOfShop() {
        return menuService.getAllMenus();
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


    // Order manipulation by admin

    @GetMapping("/getOrders")
    public ResponseEntity<?> getOrders(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fromTime,
                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime toTime,
                                       @RequestParam(required = false) String shop,
                                       @RequestParam(required = false) String student,
                                       @PageableDefault Pageable pageable) {
        return orderService.getOrdersFiltered(fromTime, toTime, shop, student, pageable);
    }

    @PutMapping("changeStatus/{orderId}")
    public ResponseEntity<?> changeStatusOrder(@PathVariable String orderId, Status status) {
        return orderService.changeOrderStatus(orderId, status);
    }

}
