package ro.agilehub.javacourse.car.hire.rental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RentalDOMapper mapper;

    private final UserApi userApi;
    private final CarApi carApi;

    public RentalServiceImpl(UserApi userApi, CarApi carApi) {
        this.userApi = userApi;
        this.carApi = carApi;
    }

    @Override
    public RentalDO createNewRental(RentalDO rentalDO) {
        //todo: add some validation
        ResponseEntity<UserDTO> user = userApi.getUser(rentalDO.getUserId());
        ResponseEntity<CarDTO> car = carApi.getCar(rentalDO.getCarId());
        Rental rental = mapper.toRental(rentalDO, user.getBody(), car.getBody());
        return mapper.toRentalDO(rentalRepository.save(rental));
    }
}
