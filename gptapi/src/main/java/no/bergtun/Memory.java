package no.bergtun;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class Memory {
    List<Message> history;

    public Memory () {
        this.history= new ArrayList<>();
        this.history.add(new Message("Always respond angry", "system"));
    }

   void addHistory(Message message){
        history.add(message);
    }

    public List<Message> getHistory() {
        return history;
    }

    public void clearHistory() {
        history.clear();
    }

    public void renameSystemMessage(String newSystemMessage) {
       // find and replace system message with new system message
       for (int i = 0; i < history.size(); i++) {
            if (history.get(i).role().equals("system")) {
                history.set(i, new Message(newSystemMessage, "system"));
            }
        }
    }

}
