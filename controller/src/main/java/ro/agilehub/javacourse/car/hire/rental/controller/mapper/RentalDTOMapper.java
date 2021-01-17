package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;

@Mapper(componentModel = "spring")
public interface RentalDTOMapper {

    @Mapping(target = "rentalStatus", source = "rentalDO.status")
    RentalDTO toRentalDTO(RentalDO rentalDO);

    @Mapping(target = "status", source = "rentalDTO.rentalStatus")
    RentalDO toRentalDO(RentalDTO rentalDTO);
}
