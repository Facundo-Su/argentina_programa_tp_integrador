import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.Cliente;
import org.main.Especialidad;
import org.main.Incidente;
import org.main.MedioNotificado.EnvioMail;
import org.main.MedioNotificado.MedioNotificado;
import org.main.Tecnico;
import org.main.repositorios.RepositorioTecnico;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class CargarDatosTest implements SimplePersistenceTest {

    private Cliente cliente ;
    private MedioNotificado mail;
    private Incidente incidente;

    private Tecnico tecnico;
    private Especialidad electrica;

    private RepositorioTecnico repositorioTecnico;
    private EntityManager entityManager;
    @BeforeEach
    public void init() {
        entityManager = Persistence.createEntityManagerFactory("simple-persistence-unit").createEntityManager();
        repositorioTecnico = new RepositorioTecnico();

        mail = new EnvioMail();
        cliente = new Cliente(); // Cambié "Cliente cliente" a "cliente"
        cliente.setNombre("Facundo");
        cliente.setRazonSocial("1234123123");
        cliente.setCuit("12345678901"); // Cambia esto con un CUIT válido
        cliente.setMedioNotificado(mail);




        tecnico = new Tecnico();
        tecnico.setNombre("santiago");
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

    }


    @Test
    public void cargarDatos(){
        repositorioTecnico.agregarTecnico(tecnico,entityManager);

    }
}
