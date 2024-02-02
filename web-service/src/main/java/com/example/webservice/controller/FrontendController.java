package com.example.webservice.controller;

import com.example.clientservice.client.UserProfile;
import com.example.webservice.client.UserViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontendController {

    @GetMapping("/showUser")
    public String showUserPage(@RequestParam("id") int userId, Model model) {
        // Выполните GET-запрос к другому микросервису для получения объекта UserProfile по идентификатору
        UserProfile userProfile = getUserProfileFromOtherService(userId);

        // Создайте внутренний объект для передачи Thymeleaf
        UserViewModel userViewModel = convertToUserViewModel(userProfile);

        // Передайте объект в Thymeleaf модель
        model.addAttribute("userViewModel", userViewModel);

        // Верните имя Thymeleaf шаблона
        return "user-profile";
    }

    private UserProfile getUserProfileFromOtherService(int id) {
        // Реализуйте логику выполнения GET-запроса к другому микросервису для получения UserProfile
        // В этом примере используется заглушка
        return new UserProfile(id, "username", "fullname", "email");
    }

    private UserViewModel convertToUserViewModel(UserProfile userProfile) {
        // Реализуйте логику преобразования UserProfile во внутренний объект UserViewModel
        // В этом примере используется простой конструктор UserViewModel
        return new UserViewModel(userProfile.getUsername(), userProfile.getFullname(), userProfile.getEmail());
    }
}
