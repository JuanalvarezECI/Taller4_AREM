package com.eci.arep4.Controller;

import com.eci.arep4.Model.LogEntry;
import com.eci.arep4.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LogServiceController {

    @Autowired
    private LogService logService;

    @PostMapping
    public List<LogEntry> logMessage(@RequestBody String message) {
        logService.saveMessage(message);
        return logService.getLast10Messages();
    }
}
