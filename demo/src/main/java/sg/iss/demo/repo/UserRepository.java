package sg.iss.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
