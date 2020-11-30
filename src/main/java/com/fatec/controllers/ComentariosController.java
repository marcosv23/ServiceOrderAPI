import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.fatec.entities.Comentario;
import com.fatec.repositories.ComentarioRepository;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentariosController {

  @Autowired
  ComentarioRepository comentarioRepository;

  @RequestMapping(method = RequestMethod.GET)
  public List<Comentario> findAll() {

    return comentarioRepository.findAll();
  }

  public Optional<Comentario> findOne(@PathVariable Integer id) {
    return comentarioRepository.findById(id);
  }

}