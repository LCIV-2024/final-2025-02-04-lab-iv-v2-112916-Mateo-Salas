package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.NewDeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import ar.edu.utn.frc.tup.lciii.repositories.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeviceDto PostDevice(DeviceDto device) {
        Optional<Device> existe = deviceRepository.getByHostName(device.getHostname());
        if(existe.isPresent()){
            return null;
        } else {
            Device deviceNuevo = modelMapper.map(device, Device.class);
            deviceNuevo.setCreatedDate(LocalDateTime.now());
            Device save = deviceRepository.save(deviceNuevo);
            return modelMapper.map(save, DeviceDto.class);
        }
    }

    @Override
    public List<DeviceDto> GetDevicesByType(ETypeDevice type) {
        List<Device> devices = deviceRepository.getByType(type);
        List<DeviceDto> listDevicesDto = new ArrayList<>();
        devices.forEach(device -> {
            DeviceDto deviceDto = modelMapper.map(device, DeviceDto.class);
            listDevicesDto.add(deviceDto);
        });
        return listDevicesDto;
    }

    @Override
    public Device getDeviceByHostName(String hostname) {
        Optional<Device> entity = deviceRepository.getByHostName(hostname);
        if (entity.isPresent()){
            return entity.get();
        }
        return null;
    }

}
