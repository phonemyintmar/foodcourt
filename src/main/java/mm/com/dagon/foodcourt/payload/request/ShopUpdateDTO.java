package mm.com.dagon.foodcourt.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopUpdateDTO {

    private String ownerName;

    // may be other image?
    private String shopProfileImg;

    private String phoneNo;
}
