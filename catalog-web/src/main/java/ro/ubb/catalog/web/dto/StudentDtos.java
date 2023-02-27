package ro.ubb.catalog.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class StudentDtos {
    private Set<StudentDto> artistDtos;

    public Set<StudentDto> getArtistDtos() {
        return artistDtos;
    }

    public void setArtistDtos(Set<StudentDto> artistDtos) {
        this.artistDtos = artistDtos;
    }
}
