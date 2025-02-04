package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.repositories.TelemetryRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TelemetryServiceImplTest {
    @MockBean
    private TelemetryRepository telemetryRepository;

    @MockBean
    private DeviceService deviceService;

    @SpyBean
    private TelemetryService telemetryService;

    @Test
    void postTelemetryTest_True() {
        TelemetryDto dto = getTelemetryDTO();
        Device device = getDeviceEntity();
        Telemetry saveTelemetry = getTelemetryEntity();
        when(deviceService.getDeviceByHostName(dto.getHostname())).thenReturn(device);
        when(telemetryRepository.save(any())).thenReturn(saveTelemetry);

        TelemetryDto result = telemetryService.postTelemetry(dto);
        Assertions.assertNotNull(result);
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
    private Telemetry getTelemetryEntity (){
        Telemetry entity = new Telemetry();
        entity.setHostname("PC-001");
        entity.setCpuUsage(75.5);
        entity.setHostDiskFree(60.2);
        entity.setMicrophoneState("active");
        entity.setScreenCaptureAllowed(false);
        entity.setAudioCaptureAllowed(true);
        LocalDateTime time = LocalDateTime.of(2024,8,30,00,00,00);
        entity.setDataDate(time);
        entity.setId(1L);
        return entity;
    }

    private TelemetryDto getTelemetryDTO (){
        TelemetryDto telemetryDto = new TelemetryDto();
        telemetryDto.setHostname("PC-001");
        telemetryDto.setCpuUsage(75.5);
        telemetryDto.setHostDiskFree(60.2);
        telemetryDto.setMicrophoneState("active");
        telemetryDto.setScreenCaptureAllowed(false);
        telemetryDto.setAudioCaptureAllowed(true);
        LocalDateTime time = LocalDateTime.of(2024,8,30,00,00,00);
        telemetryDto.setDataDate(time);
        return telemetryDto;
    }
    /*
    {
  "hostname": "PC-001",
  "cpuUsage": 75.5,
  "hostDiskFree": 60.2,
  "microphoneState": "active",
  "screenCaptureAllowed": false,
  "audioCaptureAllowed": true,
  "dataDate": "2024-08-30T14:30:00Z"
}
     */
}