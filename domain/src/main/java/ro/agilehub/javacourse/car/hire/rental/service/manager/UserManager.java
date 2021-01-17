package ro.agilehub.javacourse.car.hire.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;

import java.util.Optional;

public interface UserManager {

    Optional<UserDO> getById(String id);
}
