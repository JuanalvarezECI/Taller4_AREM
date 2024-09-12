package com.eci.arep4.Repository;

import com.eci.arep4.Model.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LogRepository extends MongoRepository<LogEntry, String> {
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}