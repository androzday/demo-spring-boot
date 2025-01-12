package com.routebus.demo_spring_boot.controller;



import com.routebus.demo_spring_boot.common.Response;
import com.routebus.demo_spring_boot.constant.URLS;
import com.routebus.demo_spring_boot.model.dto.BusRouteDTO;
import com.routebus.demo_spring_boot.service.BusRouteService;
import com.routebus.demo_spring_boot.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLS.BUS_ROUTE.MODULE)
public class BusRouteController {
    @Autowired
    private BusRouteService busRouteService;

    @RequestMapping(value = URLS.BUS_ROUTE.SAVE,method = RequestMethod.POST)
    public Response save(@RequestBody BusRouteDTO busRouteDTO){
        try {
            busRouteService.save(busRouteDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS_ROUTE.UPDATE,method = RequestMethod.POST)
    public Response update(@RequestBody BusRouteDTO busRouteDTO){
        try {
            busRouteService.update(busRouteDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS_ROUTE.DELETE,method = RequestMethod.POST)
    public Response delete(@RequestParam Long id){
        try {
            busRouteService.delete(id);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS_ROUTE.FIND_ONE,method = RequestMethod.GET)
    public Response findOne(@RequestParam Long id){
        try {
            BusRouteDTO busRouteDTO = busRouteService.findOne(id);
            return ResponseUtils.getSuccessResponse(busRouteDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.BUS_ROUTE.FIND_ALL,method = RequestMethod.GET)
    public Response findAll(Pageable pageable){
        try {
            List<BusRouteDTO> busRouteDTO = busRouteService.findAll(pageable);
            return ResponseUtils.getSuccessResponse(busRouteDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
}
