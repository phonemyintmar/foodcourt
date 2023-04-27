package mm.com.dagon.foodcourt.logic.implementations;

import mm.com.dagon.foodcourt.database.model.Student;
import mm.com.dagon.foodcourt.database.repo.StudentRepository;
import mm.com.dagon.foodcourt.logic.IStudentService;
import mm.com.dagon.foodcourt.payload.request.StudentCreateDTO;
import mm.com.dagon.foodcourt.payload.request.StudentUpdateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> getHistory(String studentId) {
        return null;
    }

    public ResponseEntity<?> createStudent(StudentCreateDTO createDTO) {
        Student student = modelMapper.map(createDTO, Student.class);
        studentRepository.save(student);
        return
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(String id, StudentUpdateDTO updateDTO) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new Exception("Student not found with id: " + id));
        modelMapper.map(updateDTO, student);
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
    }


}
