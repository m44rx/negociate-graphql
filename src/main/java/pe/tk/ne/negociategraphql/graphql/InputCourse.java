package pe.tk.ne.negociategraphql.graphql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputCourse {
    private Long id;
    private String name;
    private String category;
    private String teacher;
}
