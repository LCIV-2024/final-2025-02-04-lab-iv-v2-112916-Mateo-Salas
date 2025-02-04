package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.NewDeviceDto;
import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("")
    public ResponseEntity<DeviceDto> postDevice(@RequestBody DeviceDto device)
    {
        DeviceDto deviceDto = deviceService.PostDevice(device);
        if(deviceDto != null){
            //return (ResponseEntity<DeviceDto>) ResponseEntity.created(URI.create("/api/device/"+deviceDto.getId()));
            return ResponseEntity.ok(deviceDto);
        } else {
            return ResponseEntity.badRequest().body(deviceDto);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<DeviceDto>> GetDevicesByType(@PathParam("type") ETypeDevice type){
        List<DeviceDto> listDevices = deviceService.GetDevicesByType(type);
        return ResponseEntity.ok(listDevices);
    }

}