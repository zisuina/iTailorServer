package hibernate.elements;

import javax.persistence.*;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "search_words")
public class SearchWord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wordID;
    private String context;

    public int getWordID() {
        return wordID;
    }

    public void setWordID(int wordID) {
        this.wordID = wordID;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
