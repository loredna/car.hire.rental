package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public interface UserDOMapper {

    @Mapping(target = "id", source = "userDTO.id")
    UserDO toUserDO(UserDTO userDTO);
}
