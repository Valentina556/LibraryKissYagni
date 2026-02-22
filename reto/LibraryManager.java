package com.biblioteca.challenge.review;
 
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
 
@Service("challengeLibraryManager") 
public class LibraryManager {
 
    private final Map<String, String> books = new HashMap<>();
 
    public LibraryManager() {
        books.put("1", "El Quijote");
        books.put("2", "Cien Años de Soledad");
        books.put("3", "1984");
    }

    public boolean exists(String bookId) {
        return books.containsKey(bookId);
    }
 
    public Map<String, String> getBooks() {
        return new HashMap<>(books);
    }
    
}
 
 