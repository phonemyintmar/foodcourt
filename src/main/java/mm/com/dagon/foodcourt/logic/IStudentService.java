package mm.com.dagon.foodcourt.logic;

import mm.com.dagon.foodcourt.payload.request.MakeOrderRequest;
import mm.com.dagon.foodcourt.payload.request.StudentCreateDTO;
import mm.com.dagon.foodcourt.payload.request.StudentUpdateDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IStudentService {

    ResponseEntity<?> createStudent(StudentCreateDTO createDTO);

    ResponseEntity<?> getStudentById(String id);

    ResponseEntity<?> getAllStudents();

    ResponseEntity<?> updateStudent(String id, StudentUpdateDTO updateDTO) throws Exception;

    ResponseEntity<?> deleteStudent(String id);

}
