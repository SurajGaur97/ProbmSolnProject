package programsProblem.practice.web.ListOfDifferentTypes;

import programsProblem.practice.common.DriverClass;

public class Utilization implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        RequiredList requiredList = new RequiredList();
        requiredList.addElement(new Images());
        requiredList.addElement(new Dates());

        for (ElementList ele : requiredList.getAllElements()){
            ele.printName();
        }

        System.out.println(requiredList.getElementByNdx(0));
        System.out.println(requiredList.getElementByNdx(1));
    }
}
