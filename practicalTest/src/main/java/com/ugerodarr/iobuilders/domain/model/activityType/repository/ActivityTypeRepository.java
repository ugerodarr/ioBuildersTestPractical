package com.ugerodarr.iobuilders.domain.model.activityType.repository;

import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, BigInteger> {
}
