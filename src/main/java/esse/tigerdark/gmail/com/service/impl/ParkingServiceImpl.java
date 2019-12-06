package esse.tigerdark.gmail.com.service.impl;

import esse.tigerdark.gmail.com.models.Parking;
import esse.tigerdark.gmail.com.repository.ParkingDao;
import esse.tigerdark.gmail.com.service.ParkingService;
import esse.tigerdark.gmail.com.utils.SomeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.12.2019.
 */
@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingDao dao;


    @Override
    public Integer getFreeParking() {
        return dao.getFreePlace();
    }

    @Override
    public Boolean isOpen() {
        List<Parking> parkingList = getAll();
        for(Parking parking : parkingList){
            if(parking.getIsEmpty())
                return true;
        }
        return false;
    }

    @Override
    public Parking save(Parking parking) {
        return null;
    }

    @Override
    public List<Parking> getAll() {
        return dao.getAll();
    }

    @Override
    public Parking get(Integer id) {
        return null;
    }
}
