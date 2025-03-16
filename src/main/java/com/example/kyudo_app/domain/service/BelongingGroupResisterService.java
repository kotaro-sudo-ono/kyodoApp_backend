package com.example.kyudo_app.domain.service;

import com.example.kyudo_app.domain.model.BelongingGroup;
import com.example.kyudo_app.infrastructure.external.BelongingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BelongingGroupResisterService {

    public final BelongingGroupRepository belongingGroupRepository;

    @Autowired
    public BelongingGroupResisterService(BelongingGroupRepository belongingGroupRepository){
        this.belongingGroupRepository = belongingGroupRepository;
    }

    @Transactional
    public BelongingGroup registerBelongingGroup(BelongingGroup belongingGroup){
        return belongingGroupRepository.save(belongingGroup);
    }
}
