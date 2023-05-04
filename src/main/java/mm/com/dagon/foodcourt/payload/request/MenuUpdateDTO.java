package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuUpdateDTO {

    private String shopId;

    private String dishName;

    private String dishPrice;

    private Boolean isAvailable;

    private List<String> options;
}
