package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DemoController {

    @GetMapping("/showForm")
    
    public String showForm(Model model) {
        model.addAttribute("formObject", new YourFormObject());
        return "trial";
    }

    @PostMapping("/submitForm")
    public String submitForm(YourFormObject yourFormObject) {
       // registerUser("sandra","sandrabassem2002@gmail.com","01200559178","sandra_bassem","123456sandra");

        return "home";
    }


    public class YourFormObject {
        private String fieldName;
        private int age;

        public int getAge() {
            return age;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }
    }
}



