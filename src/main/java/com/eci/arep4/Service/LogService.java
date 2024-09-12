package com.eci.arep4.Service;

import com.eci.arep4.Model.LogEntry;
import com.eci.arep4.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void saveMessage(String message) {
        LogEntry logEntry = new LogEntry(message, new Date());
        logRepository.save(logEntry);
    }

    public List<LogEntry> getLast10Messages() {
        return logRepository.findTop10ByOrderByTimestampDesc();
    }
}