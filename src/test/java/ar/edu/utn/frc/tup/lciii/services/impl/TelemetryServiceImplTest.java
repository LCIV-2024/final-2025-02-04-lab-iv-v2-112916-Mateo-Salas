package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.repositories.TelemetryRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryServiceImplTest {
    @MockBean
    private TelemetryRepository telemetryRepository;

    @MockBean
    private DeviceService deviceService;

    @Test
    void postTelemetryTest_True() {
    }
}