package mm.com.dagon.foodcourt.database.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Getter
@Setter
public class Menu {

    @MongoId
    private String id;

    private String shopId;

    private String dishName;

    private String dishPrice;

    private Boolean isAvailable;

    //Options for dishes.
    private List<String> options;

    //feed mhr por phoe isPopular br nyr
//    private Boolean isPopular;
}
