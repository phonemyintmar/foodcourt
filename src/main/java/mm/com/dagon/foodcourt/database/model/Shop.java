package mm.com.dagon.foodcourt.database.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Getter
@Setter
public class Shop {

    @MongoId
    private String id;

    private String shopName;

    private String ownerName;

    // may be other image?
    private String shopProfileImg;

    private String phoneNo;


    //nout pine ka real information pop like owner information and everything
}
