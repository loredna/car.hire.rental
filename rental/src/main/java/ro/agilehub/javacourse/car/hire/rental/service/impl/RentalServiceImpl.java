package ro.agilehub.javacourse.car.hire.rental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
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

    public RentalServiceImpl(UserApi userApi) {
        this.userApi = userApi;
    }

    @Override
    public RentalDO createNewRental(RentalDO rentalDO) {
        //todo: add some validation
        ResponseEntity<UserDTO> user = userApi.getUser(rentalDO.getUserId());
        Rental rental = mapper.toRental(rentalDO);
        rental.setUser(user.getBody().getFirstName() + " " + user.getBody().getLastName());
        return mapper.toRentalDO(rentalRepository.save(rental));
    }
}
