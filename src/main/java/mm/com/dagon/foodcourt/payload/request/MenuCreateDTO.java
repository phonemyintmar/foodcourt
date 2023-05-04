package mm.com.dagon.foodcourt.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class MenuCreateDTO {

    @NotBlank
    private String shopId;

    @NotBlank
    private String dishName;

    @NotBlank
    private String dishPrice;

    private Boolean isAvailable;

    private List<String> options;
}
