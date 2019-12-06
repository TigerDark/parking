package esse.tigerdark.gmail.com.service;

import esse.tigerdark.gmail.com.models.Parking;

import java.util.List;

/**
 * Created by User on 06.12.2019.
 */
public interface ParkingService extends BaseService<Parking> {
    Integer getFreeParking();
    Boolean isOpen();
}
