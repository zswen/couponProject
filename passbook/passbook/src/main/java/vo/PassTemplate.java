package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>Pass Template object</h1>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    /** Merchant id the pass template belongs to */
    private Integer id;

    /** template title */
    private String title;

    /** template summary */
    private String summary;

    /** template details */
    private String desc;

    /** template maximum number */
    private Long limit;

    /** hes token */
    private Boolean hasToken;

    /** template backgroud */
    private Integer background;

    /** template start time */
    private Date start;

    /** template expired time */
    private Date end;


}
