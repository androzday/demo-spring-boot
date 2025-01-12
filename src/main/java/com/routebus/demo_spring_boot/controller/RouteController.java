package com.routebus.demo_spring_boot.controller;

import com.routebus.demo_spring_boot.common.Response;
import com.routebus.demo_spring_boot.constant.URLS;
import com.routebus.demo_spring_boot.model.dto.RouteDTO;
import com.routebus.demo_spring_boot.service.RouteService;
import com.routebus.demo_spring_boot.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLS.ROUTE.MODULE)
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping(value = URLS.ROUTE.SAVE,method = RequestMethod.POST)
    public Response save(@RequestBody RouteDTO routeDTO){
        try {
            routeService.save(routeDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.ROUTE.UPDATE,method = RequestMethod.POST)
    public Response update(@RequestBody RouteDTO routeDTO){
        try {
            routeService.update(routeDTO);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.ROUTE.DELETE,method = RequestMethod.POST)
    public Response delete(@RequestParam Long id){
        try {
            routeService.delete(id);
            return ResponseUtils.getSuccessResponse();
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.ROUTE.FIND_ONE,method = RequestMethod.GET)
    public Response findOne(@RequestParam Long id){
        try {
            RouteDTO routeDTO = routeService.findOne(id);
            return ResponseUtils.getSuccessResponse(routeDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
    @RequestMapping(value = URLS.ROUTE.FIND_ALL,method = RequestMethod.GET)
    public Response findAll(Pageable pageable){
        try {
            List<RouteDTO> routeDTO = routeService.findAll(pageable);
            return ResponseUtils.getSuccessResponse(routeDTO);
        }catch (Exception e){
            return ResponseUtils.getErrorMessageResponse(e.getMessage());
        }
    }
}
