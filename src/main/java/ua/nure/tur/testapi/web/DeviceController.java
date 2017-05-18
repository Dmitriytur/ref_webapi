package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.domain.DeviceService;
import ua.nure.tur.testapi.models.DeviceInfo;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @RequestMapping(value = "/device", method = RequestMethod.POST)
    public String  acceptData(@RequestBody DeviceInfo info){
        deviceService.acceptData(info);
        return "Ok";
    }

}
