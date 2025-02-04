package ar.edu.utn.frc.tup.lciii.controllers;
import ar.edu.utn.frc.tup.lciii.dtos.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;

    @PostMapping()
    public ResponseEntity<TelemetryDto> PostTelemetry(@RequestBody TelemetryDto newTelemetry){
        TelemetryDto telemetryDto = telemetryService.postTelemetry(newTelemetry);
        if(telemetryDto != null){
            //return (ResponseEntity<telemetryDto>) ResponseEntity.created();
            return ResponseEntity.ok(telemetryDto);
        } else {
            return ResponseEntity.badRequest().body(telemetryDto);
        }
    }


}