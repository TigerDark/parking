package esse.tigerdark.gmail.com.service;

import java.util.List;

/**
 * Created by User on 06.12.2019.
 */
public interface BaseService<T> {
    T save (T t);
    List<T> getAll();
    T get(Integer id);

}
