package esse.tigerdark.gmail.com.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Created by User on 06.12.2019.
 */
@Getter
@Setter
public class Parking implements Serializable{
    private Integer id;
    private Boolean isEmpty;
}
