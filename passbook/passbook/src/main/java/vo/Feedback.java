package vo;

import com.google.common.base.Enums;
import com.zwen.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>User feedback</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    /** User id */
    private Long userId;

    /** Feedback type */
    private String type;

    /** PassTemplate RowKey, if it is an app feedback, this will be null */
    private String templateId;

    /** template details */
    private String comment;

    public boolean validate() {
        FeedbackType feedbackType = Enums.getIfPresent(FeedbackType.class, this.type.toUpperCase()).orNull();

        return feedbackType != null && comment != null;
    }
}
