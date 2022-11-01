package com.example.cloudinary.web;

import com.example.cloudinary.model.binding.PictureBindingModel;
import com.example.cloudinary.model.entity.PictureEntity;
import com.example.cloudinary.model.view.PictureViewModel;
import com.example.cloudinary.repository.PictureRepository;
import com.example.cloudinary.service.CloudinaryService;
import com.example.cloudinary.service.impl.CloudinaryImage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final CloudinaryService cloudinaryService;

    //ТОВА НЕ ТРЯБВА ДА Е ТУК КОНТРОЛЕРИТЕ РАБОТЯТ SERVICE
    private final PictureRepository pictureRepository;

    public PictureController(CloudinaryService cloudinaryService, PictureRepository pictureRepository) {
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/add")
    public String addPicture() {
        return "add";
    }


    @PostMapping("/add")
    public String addPictureConfirm(PictureBindingModel pictureBindingModel) throws IOException {

        var picture = createPictureEntity(pictureBindingModel.getPicture(), pictureBindingModel.getTitle());
        pictureRepository.save(picture);

        return "redirect:all";
    }

    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(uploaded.getPublicId())
                .setTitle(title)
                .setUrl(uploaded.getUrl());
    }


    @GetMapping("/all")
    public String allPicture(Model model) {
        List<PictureViewModel> pictures = pictureRepository
                .findAll()
                .stream()
                .map(this::asViewModel)
                .collect(Collectors.toList());

        model.addAttribute("pictures", pictures);

        return "all";
    }

    private PictureViewModel asViewModel(PictureEntity picture) {
        return new PictureViewModel()
                .setPublicId(picture.getPublicId())
                .setTitle(picture.getTitle())
                .setUrl(picture.getUrl());

    }

    @Transactional
    @DeleteMapping("/delete")
    public String delete(@RequestParam("public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            pictureRepository.deleteAllByPublicId(publicId);
        }
        return "redirect:all";
    }


}
