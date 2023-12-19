package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DemoController {

    
    @GetMapping("/home")
    public String showForm(Model model1,Model model2,Model model3) {
        model1.addAttribute("loginFormObject", new loginFormObject());
        model2.addAttribute("RegisterFormObject", new REGFormObject());
        return "main";
    }


    //     @GetMapping("/showForm")
    // public String showForm(Model model) {
    //     System.out.println("ganna salah eldin abd el RAZEKKK");
    //     model.addAttribute("RegisterFormObject", new REGFormObject());
    //     System.out.println("bbb");
    //     return "main";
    // }


    @PostMapping("/RegisterForm")
    public String submitForm(REGFormObject yourFormObject,Model model3) {
        String textToShow = " Welcome !";
        DemoServicesIMPL trial=new DemoServicesIMPL();
        System.out.println(trial.connection);
        trial.registerUser(yourFormObject.getRegNameForm(),yourFormObject.getRegEmailForm(),yourFormObject.getRegPhoneForm(),yourFormObject.getRegUsernameForm(),yourFormObject.getRegPasswordForm());
        model3.addAttribute("myText", textToShow);
        return "main";
    }


    //boolean flag=false;
    @PostMapping("/LoginForm")
    public String submitForm(loginFormObject yourFormObject,Model model3,Model model) {

        DemoServicesIMPL trial=new DemoServicesIMPL();
        System.out.println(trial.connection);
        boolean result=trial.validateLogin(yourFormObject.getUsernameField(),yourFormObject.getPasswordField());
        if(result==true){
            model3.addAttribute("myText", " Welcome !");
            model.addAttribute("scripttrial2", "null");
            
            return "main";
        }
        else{
            model3.addAttribute( "invalidtext", "invalid username or password");
            //model3.addAttribute("myText", "failed to login try again");
            model.addAttribute("scripttrial", "null");
            return "main";
           
        }
    }

    public class REGFormObject {
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

    public class loginFormObject{

        private String usernameField;
        private String passwordField;

        public void setPasswordField(String passwordField) {
            this.passwordField = passwordField;
        }
        public void setUsernameField(String usernameField) {
            this.usernameField = usernameField;
        }
        public String getPasswordField() {
            return passwordField;
        }
        public String getUsernameField() {
            return usernameField;
        }
    }
}