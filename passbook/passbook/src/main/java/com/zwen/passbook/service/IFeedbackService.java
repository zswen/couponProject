package com.zwen.passbook.service;

import com.zwen.passbook.vo.Feedback;
import com.zwen.passbook.vo.Response;

/**
 * <h1>Feedback related features</h1>
 * 6-17
 */
public interface IFeedbackService {

    /**
     * <h2>Create feedback</h2>
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    Response createFeedback(Feedback feedback);

    /**
     * <h2>Get feedback give userId</h2>
     * @param userId {@link Feedback}
     * @return {@link Response}
     */
    Response getFeedback(Long userId);
}
