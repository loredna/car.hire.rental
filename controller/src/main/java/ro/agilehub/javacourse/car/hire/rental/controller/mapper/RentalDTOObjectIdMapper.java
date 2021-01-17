package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalDTOObjectIdMapper {

    default ObjectId toObjectId(String id) {
        if (id == null) {
            return null;
        }
        return new ObjectId(id);
    }

    default String toStringId(ObjectId id) {
        if (id == null) {
            return null;
        }
        return id.toHexString();
    }
}
