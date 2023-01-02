package com.noxilon.irc.endpoints;

import com.google.gson.Gson;
import com.noxilon.irc.endpoints.key.Key;
import com.noxilon.irc.objects.ListMessages;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Get {
    @RequestMapping(method = RequestMethod.GET, path = "/irc/get")
    public String get(String key) {
        if (Key.key.equals(key)) return "No permission!";
        Gson gson = new Gson();
        return gson.toJson(ListMessages.Get.messages);
    }
}
