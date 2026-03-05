package data;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.Song;
import repository.UserRepository;

class Stack {
    ArrayList<Song> history = new ArrayList<>();
    int top = -1;

    public void push(Song song) {
        history.add(++top, song);
    }

    public void pop() {
        if (top == -1)
            return;
        history.removeLast();
        top--;
    }

    public Song peek() {
        if (top == -1) {
            return null;
        }
        return history.getLast();
    }
}

public class SongPlayedHistory {
    Stack stack = new Stack();
    UserRepository repository = new UserRepository();

    public void addSongToHiststory(Song song, String email) throws FileNotFoundException {
        stack.push(song);
        repository.addSongToHistory(stack.history, email);
    }
}
