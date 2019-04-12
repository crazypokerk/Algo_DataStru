package com.exe.wenda.async;

import java.util.List;

/**
 * @Date 2019/4/12 12:50
 */
public interface EventHandler {
    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
