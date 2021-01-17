package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.*;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.entity.Rental;

@Mapper(componentModel = "spring", uses = {RentalObjectIdMapper.class, TimestampMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "id", source = "rental.id")
    @Mapping(target = "userId", source = "user")
    @Mapping(target = "carId", source = "car")
    RentalDO toRentalDO(Rental rental);

    @Mapping(target = "id", source = "rentalDO.id")
    @Mapping(target = "user", source = "userId")
    @Mapping(target = "car", source = "carId")
    Rental toRental(RentalDO rentalDO);
}
