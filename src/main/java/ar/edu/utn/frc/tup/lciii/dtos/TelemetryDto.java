package ar.edu.utn.frc.tup.lciii.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class TelemetryDto {
    private String hostname;
    private Double cpuUsage;
    private Double hostDiskFree;
    private String microphoneState;
    private Boolean screenCaptureAllowed;
    private Boolean audioCaptureAllowed;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd ")
    private LocalDateTime dataDate;
    //private String ip;

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
