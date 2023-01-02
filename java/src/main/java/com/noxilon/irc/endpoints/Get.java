package com.noxilon.irc.endpoints;

import com.google.gson.Gson;
import com.noxilon.irc.endpoints.key.Key;
import com.noxilon.irc.objects.ListMessages;
import org.springframework.web.bind.annotation.*;

@RestController
public class Get {
    @RequestMapping(method = RequestMethod.GET, path = "/irc/get")
    public String get(@RequestParam(value = "key", defaultValue = "") String key) {
        if (Key.key != null) {
            if (key == null) return "No permission!";
            if (!Key.key.equals(key)) return "No permission!";
        }
        Gson gson = new Gson();
        return gson.toJson(ListMessages.Get.messages);
    }
}
