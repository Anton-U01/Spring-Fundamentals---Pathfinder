package softuni.bg.pathfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.pathfinder.models.Picture;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
    List<Picture> findAll();
}
