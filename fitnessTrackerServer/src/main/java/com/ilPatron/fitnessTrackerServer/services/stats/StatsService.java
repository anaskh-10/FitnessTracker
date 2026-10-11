package com.ilPatron.fitnessTrackerServer.services.stats;

import com.ilPatron.fitnessTrackerServer.dto.GraphDTO;
import com.ilPatron.fitnessTrackerServer.dto.StatsDTO;

public interface StatsService {
    StatsDTO getStats();
    GraphDTO getGraphStats();
}
