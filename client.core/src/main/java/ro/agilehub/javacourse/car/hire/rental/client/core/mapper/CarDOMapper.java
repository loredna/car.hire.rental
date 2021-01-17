package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public interface CarDOMapper {

    @Mapping(target = "id", source = "carDTO.id")
    CarDO toCarDO(CarDTO carDTO);
}
