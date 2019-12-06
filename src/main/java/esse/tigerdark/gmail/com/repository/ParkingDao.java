package esse.tigerdark.gmail.com.repository;

import esse.tigerdark.gmail.com.models.Parking;
import esse.tigerdark.gmail.com.utils.SomeUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.12.2019.
 */
@Component
public class ParkingDao {
    public List<Parking> getAll() {
        List<Parking> out = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Parking p = new Parking();
            p.setId(i);
            int j = SomeUtil.rnd(1);
            if (j == 1)
                p.setIsEmpty(true);
            else
                p.setIsEmpty(false);
            out.add(p);
        }
        return out;
    }

    public Integer getFreePlace() {
        return 10;
    }
}
