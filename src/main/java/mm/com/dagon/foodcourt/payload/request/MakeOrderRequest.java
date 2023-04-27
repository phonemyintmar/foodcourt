package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;
import mm.com.dagon.foodcourt.database.model.Status;

import java.util.List;

@Getter
@Setter
public class MakeOrderRequest {


    private List<String> dishIds;

    private String studentId;

    private String totalCost;

    private Boolean isCustomAddress;

    private String customAddress;
}
