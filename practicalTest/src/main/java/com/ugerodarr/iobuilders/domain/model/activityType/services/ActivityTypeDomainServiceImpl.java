package com.ugerodarr.iobuilders.domain.model.activityType.services;

import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.activityType.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ActivityTypeDomainServiceImpl implements ActivityTypeDomainService{

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    public ActivityTypeDomainServiceImpl(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    public ActivityType checkActivityTypeExist(BigInteger idActivityType) throws Exception {
        Optional<ActivityType> activityType = activityTypeRepository.findById(idActivityType);
        if(activityType.isEmpty())
        {
            throw new Exception("ActivityType not found");
        }
        return activityType.get();
    }
}
