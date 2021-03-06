package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.birdwatcher.repository.BirdRepository;
import org.wecancodeit.birdwatcher.repository.DestinationsRepository;

import javax.annotation.Resource;

@Controller
public class BirdController {

    @Resource
    private BirdRepository birdRepo;

    @Resource
    private DestinationsRepository destRepo;

    @RequestMapping("/birds")
    public String displayAllBirds(Model model) {
        model.addAttribute("allBirds", birdRepo.findAll());
        return ("all-birds-template.html");
    }

    @RequestMapping("/birdOrder")
    public String displayAllBirdOrder(@PathVariable String birdOrder, Model model) {
        model.addAttribute("orderBird", birdRepo.findByBirdOrder(birdOrder));
        return ("redirect:/birds");
    }

    @RequestMapping("/country")
    public String displayAllCountries(@PathVariable String country, Model model) {
        model.addAttribute("countryBird", birdRepo.findByCountry(country));
        return ("redirect:/birds");
    }

    @RequestMapping("/region")
    public String displayAllRegions(@PathVariable String countryRegion, Model model) {
        model.addAttribute("regionBird", birdRepo.findByCountryRegion(countryRegion));
        return ("redirect:/birds");
    }

    @RequestMapping("/habitat")
    public String displayAllHabitats(@PathVariable String habitat, Model model) {
        model.addAttribute("habitatBird", birdRepo.findByHabitat(habitat));
        return ("redirect:/birds");
    }

    @RequestMapping("/bird/birdOrder/{birdOrder}")
    public String displayBirdByOrder(@PathVariable String birdOrder, Model model) {
        model.addAttribute("orderBird", birdRepo.findByBirdOrder(birdOrder));
        return ("order-template.html");
    }

    @RequestMapping("/bird/country/{country}")
    public String displayBirdByCountry(@PathVariable String country, Model model) {
        model.addAttribute("countryBird", birdRepo.findByCountry(country));
        return ("country-template.html");
    }

    @RequestMapping("/bird/region/{countryRegion}")
    public String displayBirdByRegion(@PathVariable String countryRegion, Model model) {
        model.addAttribute("regionBird", birdRepo.findByCountryRegion(countryRegion));
        return ("region-template.html");
    }

    @RequestMapping("/bird/habitat/{habitat}")
    public String displayBirdByHabitat(@PathVariable String habitat, Model model) {
        model.addAttribute("habitatBird", birdRepo.findByHabitat(habitat));
        return ("habitat-template.html");
    }

    @RequestMapping("/single-bird/{id}")
    public String displaySingleBirds(@PathVariable Long id, Model model) {
        model.addAttribute("singleBird", birdRepo.findById(id).get());
        return ("single-bird-template.html");
    }
}
