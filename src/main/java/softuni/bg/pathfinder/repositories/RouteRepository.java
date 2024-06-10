package softuni.bg.pathfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.pathfinder.models.Route;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> findAll();
    @Query("SELECT r FROM Route r LEFT JOIN r.comments c GROUP BY r ORDER BY COUNT(c) DESC LIMIT 1")

    Optional<Route> findMostCommentedRoute();
}
