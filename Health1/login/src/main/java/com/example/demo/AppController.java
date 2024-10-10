package com.example.demo;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	public String viewIndexPage() {
		return "index";
	}
	
	 @GetMapping("/login1")
	    public String login(@RequestParam(value = "error", required = false) String error,
	                        @RequestParam(value = "logout", required = false) String logout,
	                        Model model) {
	        
	        if (error != null) {
	            model.addAttribute("error", "Invalid username or password.");
	        }

	        if (logout != null) {
	            model.addAttribute("message", "You have been logged out successfully.");
	        }

	        return "login1";  // Return login.html view for login page
	    }

	    // Serve the success page after login
	    @GetMapping("/login")
	    public String dashboard() {
	        return "login";  // Return dashboard.html view after successful login
	    }
	    
	    @GetMapping("/signup")
	    public String dashboard1() {
	        return "signup";  // Return dashboard.html view after successful login
	    }

	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers",listUsers);
		return "users";
	}
	
	@GetMapping("/about")
	public String viewAboutPage() {
		return "about";
	}
	
	@GetMapping("/team")
	public String viewDoctorPage() {
		return "team";
	}
	
	@GetMapping("/service")
	public String viewServicePage() {
		return "service";
	}
	
	@GetMapping("/feature")
	public String viewFeaturePage() {
		return "feature";
	}
	
	@GetMapping("/appointment")
	public String viewAppointmentPage() {
		return "appointment";
	}
	
	@GetMapping("/testinomial")
	public String viewTestinomialPage() {
		return "testinomial";
	}
	
	@GetMapping("/contact")
	public String viewContactPage() {
		return "contact";
	}
	
	@GetMapping("/index")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/404")
	public String view404Page() {
		return "404";
	}
	@GetMapping("/testimonial")
	public String viewTestinomailPage() {
		return "testimonial";
	}

}
