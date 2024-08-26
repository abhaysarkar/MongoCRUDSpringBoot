package in.dataman.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private Integer userId;
	@NonNull
	private String name;
	@NonNull
    private Integer age;
	@NonNull
    private String gender;
	
	
	private byte[] audioRecording;  // New field for audio recording

}
