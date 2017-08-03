package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    // private static final String MAX_LONG_AS_STRING =
    // Long.toString(Long.MAX_VALUE);
    // System.out.println(Long.MAX_VALUE);//显示的是9223372036854775807
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    // @RequestMapping(method = RequestMethod.GET)
    // public String spittles(Model model) {
    // model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    // return "spittles";
    // }

    // @RequestMapping(method = RequestMethod.GET)
    // public List<Spittle> spittles(@RequestParam("max") long max,
    // @RequestParam("count") int count) {
    // return spittleRepository.findSpittles(max, count);
    // }
    @RequestMapping(method = GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // @RequestMapping(value = "/show", method = GET)
    // public String showSpittle(@RequestParam("spittle_id") long spittleId,
    // Model model) {
    // model.addAttribute(spittleRepository.findOne(spittleId));
    // return "spittle";
    // }

    // @RequestMapping(value = "/{spittleId}", method = GET)
    // public String spittle(@PathVariable("spittleId") long spittleId, Model
    // model) {
    // model.addAttribute(spittleRepository.findOne(spittleId));
    // return "spittle";
    // }

    @RequestMapping(value = "/{spittleId}", method = GET)
    public String spittle(@PathVariable long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}