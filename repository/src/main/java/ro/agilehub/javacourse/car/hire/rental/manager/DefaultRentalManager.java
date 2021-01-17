package ro.agilehub.javacourse.car.hire.rental.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.service.manager.RentalManager;

@Component
@RequiredArgsConstructor
public class DefaultRentalManager implements RentalManager {

    private final RentalRepository rentalRepository;
    private final RentalDOMapper mapper;

    @Override
    public RentalDO save(RentalDO rentalDO) {
        var newRental = mapper.toRental(rentalDO);
        rentalRepository.save(newRental);
        return mapper.toRentalDO(rentalRepository.save(newRental));
    }
}
