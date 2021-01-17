package ro.agilehub.javacourse.car.hire.rental.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
public class UserDO {

    private String id;
    private String email;
    private String password;
    private String username;
    private String firstName;
    private String lastName;
    //private UserCountryDO country;
    private String licenseNumber;
    private StatusDO status;
    private String title;
}
