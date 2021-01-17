package ro.agilehub.javacourse.car.hire.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(of = "_id")
@Document(collection = "rental")
public class Rental {

    @Id
    @Field("_id")
    private ObjectId id;
    private String user;
    private String car;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private String status;
}
