package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Sprint;

import java.util.List;

public interface SprintService {
    public List<Sprint> getSprintByMarathonId(Long id);
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon);
    public Sprint createOrUpdateSprint(Sprint sprint);
    public Sprint getSprintById(Long id);
}
