package by.controller;

import by.entity.City;
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
import java.util.List;

@Controller
@RequestMapping(value = {"/city"})
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private InfoService infoService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("cityList", cityService.getAll());
        return "city/list";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") Long id) {
        City city = cityService.get(id);
        model.addAttribute("city", city);
        model.addAttribute("infoList", city.getInfoList());
        return "city/info";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String empty() {
        return "/city/create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String create(@Valid City city) {
        cityService.create(city);
        return "redirect:";
    }

    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.get(id));
        return "city/update";
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String update(@Valid City city) {
        cityService.update(city);
        return "redirect:";
    }

    @RequestMapping(value = {"/remove/{id}"}, method = RequestMethod.GET)
    public RedirectView delete(@PathVariable("id") Long id) {
        cityService.delete(id);
        return new RedirectView("/city");
    }
}
