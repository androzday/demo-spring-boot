package com.routebus.demo_spring_boot.controller;

import com.routebus.demo_spring_boot.common.Response;
import com.routebus.demo_spring_boot.constant.URLS;
import com.routebus.demo_spring_boot.utils.ResponseUtils;
import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import com.routebus.demo_spring_boot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLS.DRIVER.MODULE)
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping(value = URLS.DRIVER.SAVE,method = RequestMethod.POST)
    public Response save(@RequestBody DriverDTO driverDTO){
        try {
            driverService.save(driverDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.DRIVER.UPDATE,method = RequestMethod.POST)
    public Response update(@RequestBody DriverDTO driverDTO){
        try {
            driverService.update(driverDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.DRIVER.DELETE,method = RequestMethod.POST)
    public Response delete(@RequestParam Long id){
        try {
            driverService.delete(id);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.DRIVER.FIND_ONE,method = RequestMethod.GET)
    public Response findOne(@RequestParam Long id){
        try {
            DriverDTO driverDTO = driverService.findOne(id);
            return ResponseUtils.getSuccessResponse(driverDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.DRIVER.FIND_ALL,method = RequestMethod.GET)
    public Response findAll(Pageable pageable){
        try {
            List<DriverDTO> driverDTO = driverService.findAll(pageable);
            return ResponseUtils.getSuccessResponse(driverDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
}
