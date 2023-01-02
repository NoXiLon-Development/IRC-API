package com.noxilon.irc.endpoints;

import com.noxilon.irc.endpoints.key.Key;
import com.noxilon.irc.objects.ListMessages;
import com.noxilon.irc.objects.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class Set {
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.GET}, path = "/irc/send")
    public void put(@RequestParam("message") String message, @RequestParam("username") String username, @RequestParam(value = "key", defaultValue = "") String key) {
        if (Key.key != null) {
            if (key == null) return;
            if (!Key.key.equals(key)) return;
        }
        if (ListMessages.Get.messages.size() >= 40) ListMessages.Get.messages.clear();
        ListMessages.Get.messages.add(new Message(message, username));
    }
}
