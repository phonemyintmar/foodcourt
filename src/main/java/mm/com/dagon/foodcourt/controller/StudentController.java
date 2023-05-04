package mm.com.dagon.foodcourt.controller;

import mm.com.dagon.foodcourt.logic.IOrderService;
import mm.com.dagon.foodcourt.logic.IStudentService;
import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import mm.com.dagon.foodcourt.payload.request.StudentCreateDTO;
import mm.com.dagon.foodcourt.payload.request.StudentUpdateDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    private final IOrderService orderService;

    private final IStudentService studentService;

    public StudentController(IOrderService orderService, IStudentService studentService) {
        this.orderService = orderService;
        this.studentService = studentService;
    }

    @PostMapping("makeOrder")
    public ResponseEntity<?> makeOrder(@RequestBody @Valid MakeOrderRequest orderRequest) {
        return orderService.makeOrder(orderRequest);
    }

    @GetMapping("/getHistory/{id}")
    public ResponseEntity<?> getOrderHistory(@PathVariable String id, @PageableDefault Pageable pageable) {
        return orderService.getStudentOrder(id, pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentCreateDTO studentCreateDTO) {
        return studentService.createStudent(studentCreateDTO);
    }

//    @GetMapping("/list")
//    public ResponseEntity<?> getStudentList() {
//        return null;
//    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getStudentDetail(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody @Valid StudentUpdateDTO updateDTO) throws Exception {
        return studentService.updateStudent(id, updateDTO);
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteStudent() {
//        return null;
//    }


}
