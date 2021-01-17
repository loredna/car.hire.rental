package ro.agilehub.javacourse.car.hire.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.service.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.service.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.service.manager.UserManager;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalManager rentalManager;
    private final UserManager userManager;
    private final CarManager carManager;

    @Override
    public RentalDO createNewRental(RentalDO rentalDO) {
        var userDO = userManager.getById(rentalDO.getUserId());
        var carDO = carManager.getById(rentalDO.getCarId());
        if (userDO.isPresent() && carDO.isPresent()) {
            rentalDO.setStatus(RentalStatusDO.ACTIVE);
            return rentalManager.save(rentalDO);
        }
        throw new NoSuchElementException();
    }
}
