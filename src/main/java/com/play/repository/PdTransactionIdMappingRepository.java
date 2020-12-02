package com.play.repository;

import com.play.dao.PdTransactionIdMapping;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.List;

@Repository
public interface PdTransactionIdMappingRepository extends JpaRepository<PdTransactionIdMapping, Integer> {

    Page<PdTransactionIdMapping> findByEnterpriseIdAndIsScheduled(int enterpriseId, PdTransactionIdMapping.IsScheduled isScheduled, Pageable pageable);

    Page<PdTransactionIdMapping> findByIsScheduled(PdTransactionIdMapping.IsScheduled isScheduled, Pageable pageable);

    Page<PdTransactionIdMapping> findByAgentIdAndEnterpriseIdAndIsScheduled(int agentId, int enterpriseId, PdTransactionIdMapping.IsScheduled isScheduled, Pageable pageable);

    @Join(value = "user",alias = "u")
    Page<PdTransactionIdMapping> findByAgentIdAndAgentFirstNameContainsAndEnterpriseIdAndIsScheduled
            (int agentId, String name, int enterpriseId, PdTransactionIdMapping.IsScheduled isScheduled, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from pd_transaction_id_mapping as pd inner join pd_agent on pd_agent.id=pd.agent_id inner join ent on ent.id=pd.enterprise_id inner join user on user.id=pd.user_id where pd.agent_id =:agentId and pd.enterprise_id=:enterpriseId and pd.is_scheduled=:isScheduled order by user.fname desc limit :from,:to")
    List<PdTransactionIdMapping> myfirstJoinExp(int agentId, int enterpriseId, String isScheduled,int from,int to);

}
