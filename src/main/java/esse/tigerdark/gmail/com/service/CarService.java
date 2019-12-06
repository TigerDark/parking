package esse.tigerdark.gmail.com.service;

import esse.tigerdark.gmail.com.models.Car;

import java.util.List;

/**
 * Created by User on 06.12.2019.
 */
public interface CarService extends BaseService<Car> {
    List<Car> getCarByNumber(String number);
}
