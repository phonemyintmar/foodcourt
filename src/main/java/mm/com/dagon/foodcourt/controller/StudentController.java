package mm.com.dagon.foodcourt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/getHistory/{id}")
    public ResponseEntity<?> getOrderHistory(@PathVariable String id) {
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent() {
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getStudentList() {
        return null;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getStudentDetail(@PathVariable String id) {
        return null;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent() {
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent() {
        return null;
    }

}
