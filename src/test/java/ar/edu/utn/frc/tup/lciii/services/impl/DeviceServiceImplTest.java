package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import ar.edu.utn.frc.tup.lciii.repositories.DeviceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DeviceServiceImplTest {
    @MockBean
    private DeviceRepository deviceRepository;

    @SpyBean
    private DeviceServiceImpl deviceService;


    @Test
    void postDeviceTest_True() {
        DeviceDto nuevoDevice = getDeviceDto();
        Device entity = getDeviceEntity();
        when(deviceRepository.getByHostName(getDeviceDto().getHostname())).thenReturn(Optional.empty());
        when(deviceRepository.save(any())).thenReturn(entity);

        DeviceDto result = deviceService.PostDevice(nuevoDevice);

        Assertions.assertNotNull(result);

    }
    @Test
    void postDeviceTest_False() {
        DeviceDto nuevoDevice = getDeviceDto();
        Device entity = getDeviceEntity();
        when(deviceRepository.getByHostName(getDeviceDto().getHostname())).thenReturn(Optional.of(entity));

        DeviceDto result = deviceService.PostDevice(nuevoDevice);

        Assertions.assertNull(result);

    }

    @Test
    void getDevicesByTypeTest_True() {
        Device device1 = getDeviceEntity();
        when(deviceRepository.getByType(ETypeDevice.Laptop)).thenReturn(List.of(device1));
        List<DeviceDto> resultList = deviceService.GetDevicesByType(ETypeDevice.Laptop);
        Assertions.assertEquals(resultList.size(), 1);
    }

    @Test
    void getDeviceByHostNameTest_True() {
        String hostname = "PC-001";
        Device entity = getDeviceEntity();
        when(deviceRepository.getByHostName(hostname)).thenReturn(Optional.of(entity));
        Device result = deviceService.getDeviceByHostName(hostname);
        Assertions.assertEquals(result.getHostName(), hostname);
    }

    @Test
    void getDeviceByHostNameTest_False() {
        String hostname = "PC-001";
        when(deviceRepository.getByHostName(hostname)).thenReturn(Optional.empty());
        Device result = deviceService.getDeviceByHostName(hostname);
        Assertions.assertNull(result);
    }


    private Device getDeviceEntity(){
        Device entity = new Device();
        entity.setHostName("PC-001");
        LocalDateTime time = LocalDateTime.of(2025,4,2,00,00,00);
        entity.setCreatedDate(time);
        entity.setMacAddress("00:1A:2B:3C:4D:5");
        entity.setOs("Windows 11");
        entity.setType(ETypeDevice.Laptop);
        return entity;
    }

    private DeviceDto getDeviceDto(){
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setHostname("PC-001");
        deviceDto.setMacAddress("00:1A:2B:3C:4D:5");
        deviceDto.setOs("Windows 11");
        deviceDto.setType(ETypeDevice.Laptop);
        return deviceDto;
    }
}