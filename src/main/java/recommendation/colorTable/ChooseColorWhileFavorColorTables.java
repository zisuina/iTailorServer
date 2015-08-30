package recommendation.colorTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/29.
 */
public class ChooseColorWhileFavorColorTables {
    List<ChooseColorWhileFavorColorTable> chooseColorWhileFavorColorTables
            = new ArrayList<ChooseColorWhileFavorColorTable>();

    public ChooseColorWhileFavorColorTables(List<ChooseColorWhileFavorColorTable> chooseColorWhileFavorColorTables) {
        this.chooseColorWhileFavorColorTables = chooseColorWhileFavorColorTables;
    }

    public List<ChooseColorWhileFavorColorTable> getChooseColorWhileFavorColorTables() {
        return chooseColorWhileFavorColorTables;
    }

    public void setChooseColorWhileFavorColorTables(ArrayList<ChooseColorWhileFavorColorTable> chooseColorWhileFavorColorTables) {
        this.chooseColorWhileFavorColorTables = chooseColorWhileFavorColorTables;
    }
}
