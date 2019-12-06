package esse.tigerdark.gmail.com.utils;

import esse.tigerdark.gmail.com.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by User on 06.12.2019.
 */
@Getter
@Setter
public class ResponsMessage<T> {
    private T result;
    private ResultCode resultCode;
    private String details;

    public ResponsMessage(T result, ResultCode resultCode, String details) {
        this.result = result;
        this.resultCode = resultCode;
        this.details = details;
    }
}
