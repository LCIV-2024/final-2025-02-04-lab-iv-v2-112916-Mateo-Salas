package ar.edu.utn.frc.tup.lciii.dtos;

import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class DeviceDto {

    private String hostname;
    private ETypeDevice type;
    private String os;
    private String macAddress;
}
/*
"hostname": "PC-001",
  "type": "Laptop",
  "os": "Windows 11",
  "macAddress": "00:1A:2B:3C:4D:5E"
 */