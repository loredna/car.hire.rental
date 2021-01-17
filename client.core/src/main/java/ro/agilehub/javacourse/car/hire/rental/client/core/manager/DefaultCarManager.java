package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.service.manager.CarManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultCarManager implements CarManager {

    private final CarApi carApi;
    private final CarDOMapper carDOMapper;

    @Override
    public Optional<CarDO> getById(String id) {
        var carDTOResponseEntity = carApi.getCar(id);
        return Optional.ofNullable(carDTOResponseEntity.getBody())
                .map(carDOMapper::toCarDO);
    }
}
