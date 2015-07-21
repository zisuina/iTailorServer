package MyWebMagic;

import java.util.Map;

/**
 * Created by liker on 21/07/2015 0021.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ItemDescription {
    private Map<String, String> descriptions;

    public ItemDescription(Map<String, String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return descriptions.toString();
    }
}
