package ar.edu.utn.frc.tup.lciii.repositories;

//import ar.edu.utn.frc.tup.lciii.entities.TelemetryEntity;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
}
