package programsProblem.singltonPattern;

public class BillPughSingletonImpl {
    private BillPughSingletonImpl() {}

    private static class BillPughSingletonHolder {
        private static final BillPughSingletonImpl INSTANCE = new BillPughSingletonImpl();
    }

    public static BillPughSingletonImpl getInstance() {
        return BillPughSingletonHolder.INSTANCE;
    }
}
