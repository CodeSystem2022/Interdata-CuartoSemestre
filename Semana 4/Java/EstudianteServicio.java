// metodo listar estudiante
import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio{
  @Autowired
  private EstudianteRepositorio estudianteRepositorio;
  
  @Override
  public List<Estudiante> listarEstudiantes(){
    List<Estudiante> estudiantes = estudianteRepositorio.findAll();
        return estudiantes;
  }
  @Override
    public Estudiante buscarEstudiantePorId(Integer idEstudiante){
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante).orElse(null);
        return estudiante;
  }
  
