package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class MakeOrderRequest {

    @NotBlank
    private List<String> dishNames;

    @NotBlank
    private List<String> dishIds;

    @NotBlank
    private String shopId;

    @NotBlank
    private String studentId;

    @NotBlank
    private String totalCost;

    @NotBlank
    private Boolean isCustomAddress;

    private String customAddress;
}
