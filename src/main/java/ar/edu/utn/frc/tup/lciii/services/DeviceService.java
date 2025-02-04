package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.NewDeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceService {
    DeviceDto PostDevice(DeviceDto device);

    List<DeviceDto> GetDevicesByType(ETypeDevice type);

    Device getDeviceByHostName(String hostname);
}
