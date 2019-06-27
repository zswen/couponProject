package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>A response object for all requests passed from controllers</h1>
 * 6-15
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /** ErrorCode: return 0 if succeeded*/
    private Integer errorCode = 0;

    /** Error message */
    private String errorMsg = "";

    /** Return Object */
    private Object data;

    /**
     * <h2>Constructor for succeeded response(errorCode 0)</h2>
     * @param data
     */
    public Response(Object data) {
        this.data = data;
    }

    /**
     * <h2>Empty response</h2>
     */
    public static Response seccess() {
        return new Response();
    }

    /**
     * <h2>Error response</h2>
     * @param errorMsg
     * @return
     */
    public static Response failure(String errorMsg) {
        return new Response(-1, errorMsg, null);
    }

}
