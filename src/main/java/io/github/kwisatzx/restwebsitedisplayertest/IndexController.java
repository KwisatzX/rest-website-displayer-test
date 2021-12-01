package io.github.kwisatzx.restwebsitedisplayertest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    private final WebsiteModel websiteModel;

    public IndexController(WebsiteModel websiteModel) {
        this.websiteModel = websiteModel;
    }

    @GetMapping({"/", ""})
    public String getIndex(Model model) {
        model.addAttribute("url", new Url());
        return "index";
    }

    @PostMapping({"/", ""})
    public String indexFormSubmission(@ModelAttribute Url url, Model model) {
        model.addAttribute("website", websiteModel.getWebsiteHtml("https://" + url.getValue()));
        return "index";
    }
}
