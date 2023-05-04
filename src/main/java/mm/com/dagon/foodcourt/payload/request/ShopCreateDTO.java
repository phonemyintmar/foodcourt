package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ShopCreateDTO {

    @NotBlank
    private String shopName;

    @NotBlank
    private String ownerName;


    // may be other image?
    @NotBlank
    private String shopProfileImg;

    @NotBlank
    private String phoneNo;
}
