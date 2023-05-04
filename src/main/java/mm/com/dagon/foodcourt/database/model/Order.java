package mm.com.dagon.foodcourt.database.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
@Setter
public class Order {

    @MongoId
    private String id;

    //MenuId
    // lo yin dish yal, dish name yl, dish price yl Dto takhu lote lite
    private List<String> dishIds;

    private List<String> dishNames;

    private String studentId;

    private String shopId;

    private String totalCost;

    private Status status;

    private Boolean isCustomAddress;

    //must be within school campus pop
    private String customAddress;

    private LocalDateTime createdAt;

    //nout pine payment method br nyr pop
//    private String paymentMethod;


}
