package mm.com.dagon.foodcourt.logic;

import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import org.springframework.http.ResponseEntity;

public interface IStudentService {
    ResponseEntity<?> getHistory(String studentId);
}
