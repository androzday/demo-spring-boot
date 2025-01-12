package com.routebus.demo_spring_boot.controller;

import com.routebus.demo_spring_boot.common.Response;
import com.routebus.demo_spring_boot.constant.URLS;
import com.routebus.demo_spring_boot.model.dto.BusDTO;
import com.routebus.demo_spring_boot.service.BusService;
import com.routebus.demo_spring_boot.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLS.BUS.MODULE)
public class BusController {
    @Autowired
    private BusService busService;

    @RequestMapping(value = URLS.BUS.SAVE,method = RequestMethod.POST)
    public Response save(@RequestBody BusDTO busDTO){
        try {
            busService.save(busDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS.UPDATE,method = RequestMethod.POST)
    public Response update(@RequestBody BusDTO busDTO){
        try {
            busService.update(busDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS.DELETE,method = RequestMethod.POST)
    public Response delete(@RequestParam Long id){
        try {
            busService.delete(id);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS.FIND_ONE,method = RequestMethod.GET)
    public Response findOne(@RequestParam Long id){
        try {
            BusDTO busDTO = busService.findOne(id);
            return ResponseUtils.getSuccessResponse(busDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS.FIND_ALL,method = RequestMethod.GET)
    public Response findAll(Pageable pageable){
        try {
            List<BusDTO> busDTO = busService.findAll(pageable);
            return ResponseUtils.getSuccessResponse(busDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
}
