package in.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.login.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
