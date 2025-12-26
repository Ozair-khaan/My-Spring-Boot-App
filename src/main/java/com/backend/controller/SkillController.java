package com.backend.controller;

import com.backend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
// ⚠️ IMPORTANT: Allow Angular (Port 4200) to access this
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {

    @Autowired
    private SkillService service;

    @GetMapping
    public List<String> getSkills() {
        return service.getAllSkills();
    }

    @PostMapping
    public List<String> addSkill(@RequestBody String skillName) {
        // Clean the input (remove quotes if Angular sends raw string)
        return service.addSkill(skillName.replaceAll("\"", ""));
    }

    @DeleteMapping("/{index}")
    public List<String> deleteSkill(@PathVariable int index) {
        return service.deleteSkillByIndex(index);
    }
}
