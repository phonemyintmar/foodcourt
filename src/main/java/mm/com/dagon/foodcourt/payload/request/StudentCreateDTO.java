package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentCreateDTO {
    @NotBlank
    private String studentId;

    @NotBlank
    private String roomNumber;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;
}
