package ro.agilehub.javacourse.car.hire.rental.client.core.manager;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.service.manager.UserManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserManager implements UserManager {

    private final UserApi userApi;
    private final UserDOMapper mapper;

    @Override
    public Optional<UserDO> getById(String id) {
        var userDTOResponseEntity = userApi.getUser(id);
        return Optional.ofNullable(userDTOResponseEntity.getBody())
                .map(mapper::toUserDO);
    }
}
