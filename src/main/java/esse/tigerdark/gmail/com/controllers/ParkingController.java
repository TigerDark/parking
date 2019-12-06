package esse.tigerdark.gmail.com.controllers;

import esse.tigerdark.gmail.com.enums.ResultCode;
import esse.tigerdark.gmail.com.models.Parking;
import esse.tigerdark.gmail.com.service.ParkingService;
import esse.tigerdark.gmail.com.utils.DataFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by User on 06.12.2019.
 */
@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "/parking/getCountFree", method = RequestMethod.GET)
    public String getCountFreePlace() {
        Integer result = null;
        ResultCode resultCode = ResultCode.FAIL;
        String details = null;
        try {
            result = parkingService.getFreeParking();
            if (result != null)
                resultCode = ResultCode.SUCCESS;

        } catch (Exception ex) {
            details = ex.getMessage();
            resultCode = ResultCode.EXCEPTION;
        }

        return DataFormatUtil.me().prepareResponseJson(result, resultCode, details);
    }

    @RequestMapping(value = "/parking/isOpen", method = RequestMethod.GET)
    public String getIsOpen() {
        Boolean result = null;
        ResultCode resultCode = ResultCode.FAIL;
        String details = null;
        try {
            result = parkingService.isOpen();
            if (result != null)
                resultCode = ResultCode.SUCCESS;

        } catch (Exception ex) {
            details = ex.getMessage();
            resultCode = ResultCode.EXCEPTION;
        }

        return DataFormatUtil.me().prepareResponseJson(result, resultCode, details);
    }
}
