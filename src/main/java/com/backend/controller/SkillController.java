package com.backend.controller;

import com.backend.entity.Skill;
import com.backend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {

    @Autowired
    private SkillService service;

    @GetMapping
    public List<Skill> getSkills() {
        return service.getAllSkills();
    }

    @PostMapping
    public List<Skill> addSkill(@RequestBody Skill skill) {
        return service.addSkill(skill.getName());
    }

    @DeleteMapping("/{id}")
    public List<Skill> deleteSkill(@PathVariable Long id) {
        return service.deleteSkillById(id);
    }
}
