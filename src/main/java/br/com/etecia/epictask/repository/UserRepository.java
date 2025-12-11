package br.com.etecia.epictask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.etecia.epictask.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
