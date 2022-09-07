package com.example.andrey.web;

import com.example.andrey.model.binding.ItemAddBindingModel;
import com.example.andrey.model.service.ItemServiceModel;
import com.example.andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "add-item";
    }

    @ModelAttribute()
    public ItemAddBindingModel itemAddBindingModel() {
        return new ItemAddBindingModel();
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }

        itemService.addItem(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") Long id, ModelAndView modelAndView) {

        modelAndView.addObject("item", itemService.findById(id));
        modelAndView.setViewName("details-item");

        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable() Long id) {
        itemService.delete(id);
        return "redirect:/";
    }


}
