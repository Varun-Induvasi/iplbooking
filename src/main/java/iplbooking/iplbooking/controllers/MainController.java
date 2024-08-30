package iplbooking.iplbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iplbooking.iplbooking.entity.Dummy;
import iplbooking.iplbooking.entity.User;
// import iplbooking.iplbooking.entity.User;
import iplbooking.repository.DummyRepository;
import iplbooking.repository.UserRepository;
// import iplbooking.repository.UserRepository;

class Response {
    public String message;
    public int code;

    public Response(String message, int code) {
        this.message = message;
        this.code = code;
    }
}

@RestController
public class MainController {

    @Autowired
    private DummyRepository dummyRepository;

    @Autowired
    private UserRepository userrepository;
    @GetMapping("/login")
    public Response login(
            @RequestParam String username,
            @RequestParam String password) {
        String USERNAME = "admin";
        String PASSWORD = "admin";

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            Response response = new Response("Login Sucessful", 200);
            return response;
        } else {
            Response response = new Response("FAILED LOGIN", 400);
            return response;
        }
    }

    @GetMapping("/add")
    public Response add(@ModelAttribute Dummy user){
    // public Response add(){
        // Dummy user = new Dummy();
        // user.setId(1);
        // user.setAge(21);
        // user.setUser("Gagan");
        // dummyRepository.save(user);
        return new Response("Succesfully Added", 200);
    }

    @GetMapping("/get")
    public Dummy get(@RequestParam int id) {
        Dummy user = (Dummy) dummyRepository.findById(id);
        return user;
    }

    // new
    @GetMapping("/register")
    public Response newRegister(@ModelAttribute User user) {
        userrepository.save(user);
        return new Response("Succesfully Registered :) ", 200);
    }

    @GetMapping("/user")
    public User getUserByUserName(@RequestParam String userName) {
        return userrepository.findByUserName(userName);
    }

    // @GetMapping("/users")
    // public List<User> getUsers() {
    //     return (List<User>) registerrepo.findAll();
    // }

    @GetMapping("/userlogin")
    public Response usesrlogin(@RequestParam String username, @RequestParam String password) {
        User user=userrepository.findByUserName(username);
        if(user!= null  && password.equals(user.getPassword())){
            String adhar = user.getAdharNo()+"";
            Response response = new Response(adhar+" -- Login Succesfull", 400);
            return response;
        }else{
            Response response = new Response("Login Failed : User Not Found", 400);
            return response;
        }
    }
}
