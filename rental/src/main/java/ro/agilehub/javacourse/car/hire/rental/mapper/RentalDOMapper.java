package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.*;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.entity.Rental;

@Mapper(componentModel = "spring", uses = {RentalObjectIdMapper.class, TimestampMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "id", source = "rental.id")
    @Mapping(target = "userId", source = "user")
    @Mapping(target = "carId", source = "car")
    RentalDO toRentalDO(Rental rental);

    @Mapping(target = "id", source = "rentalDO.id")
    @Mapping(target="user", expression="java(userDTO.getFirstName() + ' ' + userDTO.getLastName())")
    @Mapping(target="car", expression="java(carDTO.getMake() + ' ' + carDTO.getModel())")
    @Mapping(target="status", source="rentalDO.status")
    Rental toRental(RentalDO rentalDO, UserDTO userDTO, CarDTO carDTO);
}
