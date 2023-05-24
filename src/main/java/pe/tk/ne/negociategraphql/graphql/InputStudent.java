package pe.tk.ne.negociategraphql.graphql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputStudent {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String courseId;
    
}
