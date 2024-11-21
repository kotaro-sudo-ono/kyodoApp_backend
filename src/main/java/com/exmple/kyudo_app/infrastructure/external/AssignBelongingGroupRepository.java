package com.exmple.kyudo_app.infrastructure.external;

import com.exmple.kyudo_app.domain.model.BelongingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignBelongingGroupRepository extends JpaRepository<BelongingGroup, Long> {
    Optional<BelongingGroup> findById(Long groupId);
}
