package programsProblem.practice.web.ListOfDifferentTypes;

public class Images implements ElementList {
    @Override
    public void printName() {
        System.out.println("This is Image Element");
    }

    @Override
    public String toString() {
        return "This is Image Element";
    }
}
