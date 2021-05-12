package repository;

import entities.Agents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentsRepository extends JpaRepository<Agents, Long> {

    @Query("SELECT a FROM Agents a WHERE a.agent_Id = :agent_Id")
    Agents getAgentById(Long agent_Id);
}
