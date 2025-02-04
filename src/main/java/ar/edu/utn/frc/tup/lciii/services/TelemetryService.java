package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.TelemetryDto;
import org.springframework.stereotype.Service;

@Service
public interface TelemetryService {
    TelemetryDto postTelemetry(TelemetryDto newTelemetry);
}
