package ro.agilehub.javacourse.car.hire.rental.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(of = "id")
public class RentalDO {

    private ObjectId id;
    private String userId;
    private String carId;
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;
    private RentalStatusDO status;
}
