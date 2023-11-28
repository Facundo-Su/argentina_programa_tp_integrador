import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.*;
import org.main.MedioNotificado.EnvioMail;
import org.main.MedioNotificado.MedioNotificado;
import org.main.repositorios.RepositorioServicio;
import org.main.repositorios.RepositorioTecnico;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class CargarDatosTest implements SimplePersistenceTest {

    private Cliente cliente ;
    private Incidente incidente;

    private Tecnico tecnico;
    private Especialidad electrica;
    private Servicio fibertel;
    private RepositorioTecnico repositorioTecnico;
    private EntityManager entityManager;
    private RepositorioServicio repositorioServicio;
    @BeforeEach
    public void init() {
        entityManager = Persistence.createEntityManagerFactory("simple-persistence-unit").createEntityManager();
        repositorioTecnico = new RepositorioTecnico();
        repositorioServicio = new RepositorioServicio();

        cliente = new Cliente(); // Cambié "Cliente cliente" a "cliente"
        cliente.setNombre("Fernando");
        cliente.setRazonSocial("1234123123");
        cliente.setCuit("12345678901"); // Cambia esto con un CUIT válido




        tecnico = new Tecnico();
        tecnico.setNombre("fernando");
        tecnico.setDisponibilidad(true);

        // Agrega algunas especialidades al técnico
        Especialidad electrica = new Especialidad();
        electrica.setNombre("electrica");

        Especialidad internet = new Especialidad();
        internet.setNombre("internet");

        tecnico.agregarEspecialidad(internet);


        incidente = new Incidente();
        incidente.setCliente(cliente);
        incidente.setDescripcion("asdasdasdasd");
        incidente.setFechaInicio(new Date());
        incidente.setFechaPosibleFinalizacion(new Date());
        incidente.setResuelto(false);
        incidente.setTecnico(tecnico);
        incidente.agregarEspecialidad(electrica);

        fibertel = new Servicio();
        fibertel.setNombre("fibertel");
        fibertel.agregarEspecialidad(internet);

    }


    @Test
    public void cargarDatos(){
        repositorioTecnico.agregarTecnico(tecnico,entityManager);
    }
}
