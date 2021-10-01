package vn.molu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.molu.entity.Rout;

public interface RoutRepository extends JpaRepository<Rout, Long> { /*Long là kiểu dữ liệu của id*/

}
