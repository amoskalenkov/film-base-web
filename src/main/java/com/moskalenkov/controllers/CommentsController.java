package com.moskalenkov.controllers;


import com.moskalenkov.models.Comment;
import com.moskalenkov.store.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showRoles(ModelMap model) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //current user
        //String login = auth.getName();

        model.addAttribute("comments", storages.commentStorage.values());
        model.addAttribute("films", storages.filmStorage.values());
        return "film/CommentsFile";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRole(String text, String id, ModelMap model) {
        Comment comment = new Comment();
        comment.setFilm(storages.filmStorage.get(Integer.parseInt(id)));
        comment.setText(text);
        storages.commentStorage.add(comment);
        return "redirect:view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteComment(Integer id, ModelMap model) {
        storages.commentStorage.delete(id);
        return "redirect:view";
    }


}
