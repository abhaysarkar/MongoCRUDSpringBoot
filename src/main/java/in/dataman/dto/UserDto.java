package in.dataman.dto;

import in.dataman.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;
    private String name;
    private int age;
    private String gender;
    private String audioRecording;

    public UserDto(User user) {
        this.id = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.gender = user.getGender();
    }

    // Getters and Setters

    public String getAudioRecording() {
        return audioRecording;
    }

    public void setAudioRecording(String audioRecording) {
        this.audioRecording = audioRecording;
    }

}
