package mm.com.dagon.foodcourt.logic.implementations;

import mm.com.dagon.foodcourt.database.model.Order;
import mm.com.dagon.foodcourt.database.model.Student;
import mm.com.dagon.foodcourt.database.repo.OrderRepository;
import mm.com.dagon.foodcourt.database.repo.StudentRepository;
import mm.com.dagon.foodcourt.logic.IStudentService;
import mm.com.dagon.foodcourt.payload.request.StudentCreateDTO;
import mm.com.dagon.foodcourt.payload.request.StudentUpdateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static mm.com.dagon.foodcourt.payload.response.ResponseFactory.*;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> createStudent(StudentCreateDTO createDTO) {
        try {
            Student student = modelMapper.map(createDTO, Student.class);
            studentRepository.save(student);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("studentId", student.getId());
            return onSuccessWithMessage(responseMap, "000", "Student successfully created");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getStudentById(String id) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);
            return onSuccessWithMessage(studentOptional.orElse(null), "000", "Student detail data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> studentList = studentRepository.findAll();
            return onSuccessWithMessage(studentList, "000", "Student data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> updateStudent(String id, StudentUpdateDTO updateDTO) throws Exception {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return onFailWithMessage("198", "Student with the given id cannot be found");
        }
        modelMapper.map(updateDTO, student);
        studentRepository.save(student);
        return onSuccessWithMessage(student, "000", "Successfully updated student");
    }

    public ResponseEntity<?> deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return onSuccessWithMessage(null, "001", "Student deleted");
        } else {
            return onFailWithMessage("198", "Student with the given id cannot be found");
        }
    }


}
