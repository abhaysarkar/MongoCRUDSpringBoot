package in.dataman.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.dataman.dto.UserDto;
import in.dataman.entity.User;
import in.dataman.service.UserService;

@RestController
//@RequestMapping("/api")
public class UserDataController {
	
//	@Autowired
//	private UserService usrservice;
//	
//	@PostMapping("/add")
//	public User saveUser(@RequestBody User user) {
//		return usrservice.saveUser(user);
//	}
//	
//	@GetMapping("/find/{id}")
//	public Optional<User> findUser(@PathVariable int id) {
//		Optional<User> optuser = usrservice.showUser(id);
//		
//		if(optuser.isPresent()) {
//			return optuser;
//		}
//		return null;
//	}
	
	@Autowired
    private UserService usrservice;

    @PostMapping("/add")
    public User saveUser(@RequestParam("user") String userJson, @RequestParam("audio") MultipartFile audio) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        user.setAudioRecording(audio.getBytes());
        return usrservice.saveUser(user);
    }

    @GetMapping("/find/{id}")
    public Optional<User> findUser(@PathVariable int id) {
        Optional<User> optuser = usrservice.showUser(id);
        return Optional.ofNullable(optuser.orElse(null));
    }
    
//    @GetMapping("/all")
//    public List<User> getAllUsers() {
//        return usrservice.getAllUsers();
//    }
    
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        List<User> users = usrservice.getAllUsers();
        return users.stream()
                    .map(user -> {
                        UserDto userDto = new UserDto(user);
                        userDto.setAudioRecording(Base64.getEncoder().encodeToString(user.getAudioRecording()));
                        return userDto;
                    })
                    .collect(Collectors.toList());
    }
    

}
