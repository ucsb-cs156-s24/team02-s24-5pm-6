package edu.ucsb.cs156.example.repositories;

import edu.ucsb.cs156.example.entities.RecommendationRequest;
import edu.ucsb.cs156.example.entities.UCSBDate;
import edu.ucsb.cs156.example.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendationRequestRepository extends CrudRepository<RecommendationRequest, Long> {
  Iterable<RecommendationRequest> findAllByEmaiIterable(String emailString); //I assume this is what we change the former UCSBDate line to?
}

//WHERE DO WE SEE FIELDS FOR JSON FILE OF THE REC REQUEST??
