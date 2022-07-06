package ma.hamzaezzakri.springboot.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hamza Ezzakri
 * @CreatedAt 7/6/2022 3:38 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @ApiModelProperty(notes = "represents the student's ID")
    private Long id;
    @ApiModelProperty(notes = "represents the student's first name")
    private String firstName;
    @ApiModelProperty(notes = "represents the student's last name")
    private String lastName;
}
