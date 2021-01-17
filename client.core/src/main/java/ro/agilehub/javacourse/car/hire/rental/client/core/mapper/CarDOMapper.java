package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;

@Mapper(componentModel = "spring")
public interface CarDOMapper {

    CarDO toCarDO(CarDTO carDTO);
}
