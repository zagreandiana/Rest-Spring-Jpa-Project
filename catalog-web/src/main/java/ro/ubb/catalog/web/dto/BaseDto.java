package ro.ubb.catalog.web.dto;

import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@ToString
public class BaseDto implements Serializable {
    protected Long id;

    public Long setId(Long id){
        return this.id;
    }

    public Long getId() {
        return id;
    }

}
