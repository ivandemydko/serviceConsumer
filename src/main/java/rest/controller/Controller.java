package rest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.errors.AddressNotExistException;
import rest.services.GetAddressFromService;
import rest.entity.Address;


@RestController
@RequestMapping("address")
@Api(tags = "address")
public class Controller {
    @Autowired
    GetAddressFromService addressFromService;

    @GetMapping(value = "/id/{id}")
    @ApiOperation(value = "get Address", notes = "It permits to get address from restService by id")
    public Address getAddress(@PathVariable long id) {
        return addressFromService.getAddress(id);
    }

    @ExceptionHandler(AddressNotExistException.class)
    public void exceptionHandler() {
        System.err.println("This address does not exist page");
    }

}
