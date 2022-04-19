package de.sii.connector.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserCommonErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Error e, Model model) {
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        model.addAttribute("error", e.getCause());

        return "error";
    }
}
