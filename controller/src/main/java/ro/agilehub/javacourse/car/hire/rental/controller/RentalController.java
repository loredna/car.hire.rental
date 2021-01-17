package ro.agilehub.javacourse.car.hire.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.RentalDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;

import javax.validation.Valid;

@RestController
@PreAuthorize("hasAuthority('MANAGER')")
@RequiredArgsConstructor
public class RentalController implements RentalApi {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalDTOMapper mapper;

    @Override
    public ResponseEntity<RentalDTO> addRental(@Valid RentalDTO rentalDTO) {
        var rentalDO = mapper.toRentalDO(rentalDTO);
        return ResponseEntity.ok(mapper.toRentalDTO(rentalService.createNewRental(rentalDO)));
    }
}
