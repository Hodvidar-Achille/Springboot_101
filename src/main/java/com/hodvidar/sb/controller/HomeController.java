package com.hodvidar.sb.controller;

import com.hodvidar.sb.model.Song;
import com.hodvidar.sb.model.TvShow;
import com.hodvidar.sb.utils.EmailAddressChecker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/variable")
    public String homePage2(final Model model) {
        model.addAttribute("myvar", "Exercise SP 102 says hello");
        model.addAttribute("myvar2", "Hodvidar says hello too");
        return "variableTemplate";
    }

    @RequestMapping("/property")
    public String homePage3() {
         return "propertyTemplate";
    }

    @RequestMapping("/loadform")
    public String loadFormPage() {
        return "formTemplate";
    }

    @RequestMapping("/processform")
    public String loadFormPage(@RequestParam("login") final String login,
                               @RequestParam("email") final String email,
                               final Model model) {
        if(!EmailAddressChecker.isEmailValid(email)) {
            throw new IllegalArgumentException("Email '"+email+"' is invalid");
        }
        model.addAttribute("loginval", login);
        model.addAttribute("emailval", email);
        return "confirm";
    }

    @GetMapping("/songform")
    public String loadSongForm(final Model model) {
        model.addAttribute("song", new Song());
        return "songForm";
    }

    @RequestMapping("/songform")
    public String loadSongForm(@ModelAttribute final Song song,
                               final Model model) {
        model.addAttribute("song", song);
        return "confirmSong";
    }

    @GetMapping("/tvform")
    public String loadTvForm(final Model model) {
        model.addAttribute("tvshow", new TvShow());
        return "tvForm";
    }

    @RequestMapping("/tvform")
    public String loadTvForm(@Valid final TvShow tvShow,
                             final Model model,
                             final BindingResult result) {
        model.addAttribute("tvshow", tvShow);
        if(result.hasErrors()) {
            return "tvForm";
        }
        return "tvShowConfirm";
    }


}
