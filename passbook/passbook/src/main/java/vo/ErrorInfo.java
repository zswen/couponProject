package vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Error Messages/Info</h1>
 * @param <T>
 *     6-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {

    /** Error Code */
    public static final Integer ERROR = -1;

    /** Specific Error Code */
    private Integer code;

    /** Request Url */
    private String url;

    /** Error Message */
    private String message;

    /** Response Data */
    private T data;
}
