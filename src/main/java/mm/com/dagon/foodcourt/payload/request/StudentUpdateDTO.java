package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDTO {

    private String studentId;

    private String roomNumber;

    private String name;

    private String phoneNumber;
}
