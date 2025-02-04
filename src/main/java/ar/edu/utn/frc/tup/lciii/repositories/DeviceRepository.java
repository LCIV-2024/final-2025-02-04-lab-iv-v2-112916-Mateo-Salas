package ar.edu.utn.frc.tup.lciii.repositories;

//import ar.edu.utn.frc.tup.lciii.entities.DeviceEntity;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.ETypeDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    Optional<Device> getByHostName(String hostname);

    List<Device> getByType(ETypeDevice type);
}
