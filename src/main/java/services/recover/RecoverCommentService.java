package services.recover;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Comment;
import repositories.CommentRepository;

@Service
public class RecoverCommentService {

	@Autowired
    CommentRepository repo;
	
	public Comment findById(Integer id) {
		 Optional<Comment> com =  repo.findById(id);
		 return com.orElse(null);
	}
	

}
