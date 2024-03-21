package de.uniba.dsam.group.project.repos;

import de.uniba.dsam.group.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);//spring data jpa can automatically generates queries based on method name.
}
