package by.controller;

import by.entity.Info;
import by.services.CityService;
import by.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/info"})
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private CityService cityService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("infoList", infoService.getAll());
        return "info/list";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") Long id) {
        model.addAttribute("info", infoService.get(id));
        return "info/info";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String empty(Model model) {
        model.addAttribute("cityList", cityService.getAll());
        return "/info/create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String create(@Valid Info info) {
        infoService.create(info);
        return "redirect:";
    }

    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("info", infoService.get(id));
        model.addAttribute("cityList", cityService.getAll());
        return "info/update";
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String update(@Valid Info info) {
        infoService.update(info);
        return "redirect:";
    }

    @RequestMapping(value = {"/remove/{id}"}, method = RequestMethod.GET)
    public RedirectView delete(@PathVariable("id") Long id) {
        Info info = infoService.get(id);
        infoService.delete(id);
        return new RedirectView("/info");
    }
}
