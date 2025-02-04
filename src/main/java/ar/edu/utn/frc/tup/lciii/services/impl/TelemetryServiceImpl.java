package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.repositories.TelemetryRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TelemetryServiceImpl implements TelemetryService {

    @Autowired
    private TelemetryRepository telemetryRepository;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TelemetryDto postTelemetry(TelemetryDto newTelemetry) {
        Device device = deviceService.getDeviceByHostName(newTelemetry.getHostname());
        if(device == null){
            //Excepcion device no registrado
            return null;
        }
        Telemetry telemetry = modelMapper.map(newTelemetry, Telemetry.class);
        telemetry.setDevice(device);
        telemetry.setDataDate(LocalDateTime.now());
        Telemetry save = telemetryRepository.save(telemetry);

        return modelMapper.map(save, TelemetryDto.class);
    }
}
