package edu.ucsb.cs156.example.repositories;

import edu.ucsb.cs156.example.entities.RecommendationRequest;
import edu.ucsb.cs156.example.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendationRequestRepository extends CrudRepository<RecommendationRequest, Long> {
  //I removed the line that was formerly here in the other file example
}
