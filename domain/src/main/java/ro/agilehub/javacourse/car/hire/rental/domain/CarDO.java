package ro.agilehub.javacourse.car.hire.rental.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
public class CarDO {

    private String id;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String fuel;
    private String sizeClass;
    private StatusDO status;
}
