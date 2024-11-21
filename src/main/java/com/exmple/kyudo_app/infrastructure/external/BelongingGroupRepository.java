package com.exmple.kyudo_app.infrastructure.external;

import com.exmple.kyudo_app.domain.model.BelongingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BelongingGroupRepository extends JpaRepository<BelongingGroup, Long> {
}
