package com.noxilon.irc.objects;

import java.util.ArrayList;

public class ListMessages {
    public static final ListMessages Get = new ListMessages();
    public ArrayList<Message> messages = new ArrayList<>();
}
