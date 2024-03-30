package programsProblem.practice.web.ListOfDifferentTypes;

import java.util.ArrayList;
import java.util.List;

public class RequiredList {
    List<ElementList> itemsList;

    public RequiredList() {
        itemsList = new ArrayList<>();
    }

    public void addElement(ElementList item) {
        this.itemsList.add(item);
    }

    public List<ElementList> getAllElements() {
        return this.itemsList;
    }

    public ElementList getElementByNdx(Integer ndx) {
        return this.itemsList.get(ndx);
    }

}
