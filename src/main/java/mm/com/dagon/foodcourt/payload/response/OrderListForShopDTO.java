package mm.com.dagon.foodcourt.payload.response;

import lombok.Getter;
import lombok.Setter;
import mm.com.dagon.foodcourt.database.model.Status;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderListForShopDTO {

    private List<String> dishNames;

    private String studentId;

    private String totalCost;

    private Status status;

    private Boolean isCustomAddress;

    //must be within school campus pop
    private String customAddress;

    //d lo so map loh ya lr kyi kyi
    private LocalDateTime orderTime;
}
