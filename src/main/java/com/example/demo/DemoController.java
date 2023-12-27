package com.example.demo;

// java.lang.ProcessBuilder.Redirect;

import javax.validation.Valid;
import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



//@Validated
@Controller
public class DemoController {


    @GetMapping("/navigateToMain")
    public String navigateToMain(Model model1,Model model2,Model model3){
        model1.addAttribute("loginFormObject", new loginFormObject());
        model2.addAttribute("RegisterFormObject", new REGFormObject());
        model3.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        return "main";
    }

    @GetMapping("/main")
    public String showForm(Model model1,Model model2,Model model3,Model model4,Model model5) {
        model1.addAttribute("loginFormObject", new loginFormObject());
        model2.addAttribute("RegisterFormObject", new REGFormObject());
        model3.addAttribute("homeloginFormObject", new HloginFormObject());
        model4.addAttribute("homeRegisterFormObject", new HREGFormObject());
        model5.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        return "home";
    }

    @PostMapping("/homeRegisterForm")
    public String homeRegister(@Valid @ModelAttribute HREGFormObject formObject,BindingResult result ,Model model,Model model3,Model model4,Model model5,Model model6,Model model8,Model model2){
        if (result.hasErrors()) {
        model3.addAttribute("homeloginFormObject", new HloginFormObject());
        model4.addAttribute("homeRegisterFormObject", new HREGFormObject());
        model5.addAttribute("loginFormObject", new loginFormObject());
        model6.addAttribute("RegisterFormObject", new REGFormObject());
        model.addAttribute("errors", result.getAllErrors());
        model8.addAttribute("scripttrial6", "null");
            return "home";
        }
        model2.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        model3.addAttribute("homeloginFormObject", new HloginFormObject());
        model4.addAttribute("homeRegisterFormObject", new HREGFormObject());
        model5.addAttribute("loginFormObject", new loginFormObject());
        model6.addAttribute("RegisterFormObject", new REGFormObject());
        DemoServicesIMPL trial=new DemoServicesIMPL();
        trial.registerUser(formObject.getHomeregNameForm(),formObject.getHomeregEmailForm(),formObject.getHomeregPhoneForm(),formObject.getHomeregUsernameForm(),formObject.getHomeregPasswordForm());        
        //model.addAttribute("null", trial);
        return "main";
    }

    @PostMapping("/RegisterForm")
    public String submitForm(@Valid @ModelAttribute REGFormObject yourFormObject,BindingResult result,Model model,Model model2,Model model1,Model model4,Model model3,Model model7,Model model5,Model model6,Model model8,Model model9) {
        if (result.hasErrors()) {
            
        model3.addAttribute("homeloginFormObject", new HloginFormObject());
        model.addAttribute("homeRegisterFormObject", new HREGFormObject());
        model5.addAttribute("loginFormObject", new loginFormObject());
        model6.addAttribute("RegisterFormObject", new REGFormObject());
        model.addAttribute("errors", result.getAllErrors());
        model8.addAttribute("scripttrial5", "null");

            return "main";
        }
        
        model9.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        model4.addAttribute("loginFormObject", new loginFormObject());
        model1.addAttribute("RegisterFormObject", new REGFormObject());

        DemoServicesIMPL trial=new DemoServicesIMPL();
        trial.registerUser(yourFormObject.getRegNameForm(),yourFormObject.getRegEmailForm(),yourFormObject.getRegPhoneForm(),yourFormObject.getRegUsernameForm(),yourFormObject.getRegPasswordForm());
        model2.addAttribute("myText", " Welcome !");// + DemoServicesIMPL.currentUser.getName() + " !");
        model.addAttribute("scripttrial3", "null");
        return "main";
    }

    @PostMapping("/LoginForm")
    public String submitForm(loginFormObject yourFormObject,Model model3,Model model ,Model model1,Model model4,Model model5,Model model2,Model model6) {
        
        model5.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        model4.addAttribute("loginFormObject", new loginFormObject());
        model1.addAttribute("RegisterFormObject", new REGFormObject());
        DemoServicesIMPL trial=new DemoServicesIMPL();

        int result=trial.validateLogin(yourFormObject.getUsernameField(),yourFormObject.getPasswordField());
        if(result==1){
            model3.addAttribute("myText", " Welcome !");
            model.addAttribute("scripttrial2", "null");
            return "main";
        }
        else if(result==2){
            System.out.println("result 2 entered");
            model2.addAttribute("myText", " Welcome !");
            model6.addAttribute("scripttrial4", "null");
            return "main";
        }
        else{
            model3.addAttribute( "invalidtext", "invalid username or password");
            model.addAttribute("scripttrial", "null");
            return "main";
        }
    }

    @PostMapping("/homeLoginForm")
    public String homeLogin(HloginFormObject formObject,Model model,Model model1, Model model3,Model model2 ,Model model5,Model model4,Model model6 ) {
        model5.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        model3.addAttribute("loginFormObject", new loginFormObject());
        model2.addAttribute("RegisterFormObject", new REGFormObject());
        model6.addAttribute("homeloginFormObject", new HloginFormObject());
        model4.addAttribute("homeRegisterFormObject", new HREGFormObject());
        DemoServicesIMPL trial=new DemoServicesIMPL();
        int result=trial.validateLogin(formObject.getHomeusernameField(),formObject.getHomepasswordField());
        if(result==1){
        model.addAttribute("myText", " Welcome !");
        model.addAttribute("scripttrial2", "null");
            return "main";
        }
        else if(result == 2){
        model3.addAttribute("myText", " Welcome !");
        model.addAttribute("scripttrial4", "null");
        return"main";
        }
        else{
            model.addAttribute( "homeinvalidtext", "invalid username or password");
            model.addAttribute("scripttrial1", "null");
            return "home";
        }
    }

    @PostMapping("/deleteForm")
    public String deleteUser(DeleteUserFormObject object,Model model,Model model2,Model model1,Model model3){
        model1.addAttribute("loginFormObject", new loginFormObject());
        model2.addAttribute("RegisterFormObject", new REGFormObject());
        model3.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        DemoServicesIMPL trial=new DemoServicesIMPL();
        trial.deleteUser(object.getDeleteUsernameField());
        model.addAttribute("scripttrial4", "null");
        return "main";
    } 

    @GetMapping("/check-username-availability")
    @ResponseBody
    public String checkUsernameAvailability(@RequestParam String username ,Model model1,Model model2,Model model3,Model model4,Model model5) {
        model1.addAttribute("loginFormObject", new loginFormObject());
        model2.addAttribute("RegisterFormObject", new REGFormObject());
        model3.addAttribute("homeloginFormObject", new HloginFormObject());
        model4.addAttribute("homeRegisterFormObject", new HREGFormObject());
        model5.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
        DemoServicesIMPL trial=new DemoServicesIMPL();
        boolean isAvailable = trial.checkUsernameAvailability(username);
        return !isAvailable ? "taken" : "available";
    }


    // @GetMapping("/homecheck-username-availability")
    // @ResponseBody
    // public String homecheckUsernameAvailability(@RequestParam String username ,Model model1,Model model2,Model model3,Model model4,Model model5) {
    //     model1.addAttribute("loginFormObject", new loginFormObject());
    //     model2.addAttribute("RegisterFormObject", new REGFormObject());
    //     model3.addAttribute("homeloginFormObject", new HloginFormObject());
    //     model4.addAttribute("homeRegisterFormObject", new HREGFormObject());
    //     model5.addAttribute("deleteUserFormObject",new DeleteUserFormObject());
    //     DemoServicesIMPL trial=new DemoServicesIMPL();
    //     boolean isAvailable = trial.checkUsernameAvailability(username);
    //     return !isAvailable ? "taken" : "available";
    // }

    public class REGFormObject {

        @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only alphabets") 
        private String regNameForm;
        
        @Email(message = "Please provide a valid email address")
        private String regEmailForm;

        @Pattern(regexp = "\\d+", message = "Phone must contain atleast 11 digits")
        private String regPhoneForm;
        
        @Pattern(regexp = "[a-zA-Z0-9]+", message = "Username must contain only alphanumeric characters allowed")
        private String regUsernameForm;

        @Size(min = 8, message = "Password must be at least 8 characters long")
        @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$",
        message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character"
        )
        private String regPasswordForm;

        public void setRegEmailForm(String regEmailForm) {
            this.regEmailForm = regEmailForm;
        }
        public void setRegNameForm(String regNameForm) {
            this.regNameForm = regNameForm;
        }
        public void setRegPasswordForm(String regPasswordForm) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //this.regPasswordForm = encoder.encode(regPasswordForm);
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

    public class HREGFormObject {
        @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only alphabets") 
        private String homeregNameForm;

        @Email(message = "Please provide a valid email address")
        private String homeregEmailForm;

        @Size(min = 11, message = "Phone must be at least 11 digits long")
        @Pattern(regexp = "\\d+", message = "phone must contain only digits")
        private String homeregPhoneForm;

        @Pattern(regexp = "[a-zA-Z0-9]+", message = " Username must contain only alphanumeric characters allowed")
        private String homeregUsernameForm;

        @Size(min = 8, message = "Password must be at least 8 characters long")
        @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$",
        message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character"
        )
        private String homeregPasswordForm;

        public void setHomeregEmailForm(String homeregEmailForm) {
            this.homeregEmailForm = homeregEmailForm;
        }
        public void setHomeregNameForm(String homeregNameForm) {
            this.homeregNameForm = homeregNameForm;
        }
        public void setHomeregPasswordForm(String homeregPasswordForm) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //this.homeregPasswordForm = encoder.encode(homeregPasswordForm);
           this.homeregPasswordForm = homeregPasswordForm;
        }
        public void setHomeregPhoneForm(String homeregPhoneForm) {
            this.homeregPhoneForm = homeregPhoneForm;
        }
        public void setHomeregUsernameForm(String homeregUsernameForm) {
            this.homeregUsernameForm = homeregUsernameForm;
        }
        public String getHomeregEmailForm() {
            return homeregEmailForm;
        }
        public String getHomeregNameForm() {
            return homeregNameForm;
        }
        public String getHomeregPasswordForm() {
            return homeregPasswordForm;
        }
        public String getHomeregPhoneForm() {
            return homeregPhoneForm;
        }
        public String getHomeregUsernameForm() {
            return homeregUsernameForm;
        }
    }

    public class HloginFormObject{

        private String homeusernameField;
        private String homepasswordField;

        public void setHomepasswordField(String homepasswordField) {
            this.homepasswordField = homepasswordField;
        }
        public void setHomeusernameField(String homeusernameField) {
            this.homeusernameField = homeusernameField;
        }
        public String getHomepasswordField() {
            return homepasswordField;
        }
        public String getHomeusernameField() {
            return homeusernameField;
        }

    }

    public class DeleteUserFormObject{

        private String deleteUsernameField;

        public void setDeleteUsernameField(String deleteUsernameField) {
            this.deleteUsernameField = deleteUsernameField;
        }
        public String getDeleteUsernameField() {
            return deleteUsernameField;
        }


    }
}