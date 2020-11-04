package org.launchcode.javawebdevtechjobspersistent.controllers;
import java.util.Optional;
import javax.validation.Valid;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping({"skills"})
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;
    public SkillController() {
    }
    @GetMapping({"add"})
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }
    @PostMapping({"add"})
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model) {
        model.addAttribute("skill", this.skillRepository.findAll());
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            return "skills/add";
        } else {
            this.skillRepository.save(newSkill);
            return "redirect:";
        }
    }
    @GetMapping({"view/{skillId}"})
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        Optional optSkill = this.skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill)optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
