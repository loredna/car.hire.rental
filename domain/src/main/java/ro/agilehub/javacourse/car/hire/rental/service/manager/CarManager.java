package ro.agilehub.javacourse.car.hire.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;

import java.util.Optional;

public interface CarManager {

    Optional<CarDO> getById(String id);
}
