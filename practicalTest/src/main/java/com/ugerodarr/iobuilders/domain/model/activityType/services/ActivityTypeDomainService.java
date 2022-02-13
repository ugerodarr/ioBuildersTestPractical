package com.ugerodarr.iobuilders.domain.model.activityType.services;

import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;

import java.math.BigInteger;

public interface ActivityTypeDomainService {

    ActivityType checkActivityTypeExist(BigInteger idActivityType) throws Exception;

}
