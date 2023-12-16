package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DemoController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("RegisterFormObject", new YourFormObject());
        return "main";
    }

    @PostMapping("/RegisterForm")
    public String submitForm(YourFormObject yourFormObject) {
        DemoServicesIMPL trial=new DemoServicesIMPL();
        System.out.println(trial.connection);
        trial.registerUser(yourFormObject.getRegNameForm(),yourFormObject.getRegEmailForm(),yourFormObject.getRegPhoneForm(),yourFormObject.getRegUsernameForm(),yourFormObject.getRegPasswordForm());
        return "hello";
    }

    public class YourFormObject {
        private String regNameForm;
        private String regEmailForm;
        private String regPhoneForm;
        private String regUsernameForm;
        private String regPasswordForm;

        public void setRegEmailForm(String regEmailForm) {
            this.regEmailForm = regEmailForm;
        }
        public void setRegNameForm(String regNameForm) {
            this.regNameForm = regNameForm;
        }
        public void setRegPasswordForm(String regPasswordForm) {
            this.regPasswordForm = regPasswordForm;
        }
        public void setRegPhoneForm(String regPhoneForm) {
            this.regPhoneForm = regPhoneForm;
        }
        public void setRegUsernameForm(String regUsernameForm) {
            this.regUsernameForm = regUsernameForm;
        }
        public String getRegEmailForm() {
            return regEmailForm;
        }
        public String getRegNameForm() {
            return regNameForm;
        }
        public String getRegPasswordForm() {
            return regPasswordForm;
        }
        public String getRegPhoneForm() {
            return regPhoneForm;
        }
        public String getRegUsernameForm() {
            return regUsernameForm;
        }
    }
}



