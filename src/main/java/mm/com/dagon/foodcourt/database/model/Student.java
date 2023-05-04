package mm.com.dagon.foodcourt.database.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Getter
@Setter
public class Student {

    @MongoId
    private String id;

    private String studentId;

    private String roomNumber;

    private String name;

    private String phoneNumber;

    private String password;
}
