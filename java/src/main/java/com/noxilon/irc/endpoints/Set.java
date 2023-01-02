package com.noxilon.irc.endpoints;

import com.noxilon.irc.endpoints.Key.Key;
import com.noxilon.irc.objects.ListMessages;
import com.noxilon.irc.objects.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Set {
    @RequestMapping(method = RequestMethod.PUT, path = "/irc/send")
    public void put(String message, String username, String key) {
        if (Key.key.equals(key)) return;
        if (ListMessages.Get.messages.size() >= 60) ListMessages.Get.messages.clear();
        ListMessages.Get.messages.add(new Message(message, username));
    }
}
