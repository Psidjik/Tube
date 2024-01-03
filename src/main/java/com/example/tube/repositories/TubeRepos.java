package com.example.tube.repositories;

import com.example.tube.models.Tube;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TubeRepos extends JpaRepository<Tube, Integer> {

    Optional<Tube> findTubeByLength(int length);

    @Query("SELECT t FROM Tube t\n" +
            "ORDER BY t.coef ASC")
    List<Tube> allTubesByCoefASC();
}
