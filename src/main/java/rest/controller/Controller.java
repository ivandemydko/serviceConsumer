package rest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.services.GetAddressFromService;
import rest.entity.Address;


@RestController
@RequestMapping("address")
@Api(tags = "address")
public class Controller {
@Autowired
   GetAddressFromService addressFromService;



    @GetMapping(value = "/get")
    @ApiOperation(value = "get Address", notes = "It permits to get address by id")
    public Address getAddress() {
        return addressFromService.getAddress();
    }


}
