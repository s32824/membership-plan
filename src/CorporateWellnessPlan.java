public class CorporateWellnessPlan extends MembershipPlan implements RemoteAccess, Freezable {
    private int employeeCount;
    private int workshopsPerMonth;
    private boolean onlineDashboard;

    //constructor
    public CorporateWellnessPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int employeeCount, int workshopsPerMonth, boolean onlineDashboard) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.employeeCount = employeeCount;
        this.workshopsPerMonth = workshopsPerMonth;
        this.onlineDashboard = onlineDashboard;
    }

    @Override
    public String getPlanType() {
        return "Corporate Wellness";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();

        price += (employeeCount * 18);

        price += (workshopsPerMonth * 220);

        if (employeeCount >= 20) {
            price *= 0.88; //multiplying by (1 - 0.12)
        }

        if (onlineDashboard) {
            price += 80.0;
        }

        return price;
    }

    @Override
    public boolean hasOnlineAccess() {
        return onlineDashboard;
    }

    @Override
    public boolean canFreeze() {
        //duration >= 6 months AND zero workshops
        return getMonths() >= 6 && workshopsPerMonth == 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Employees: %d, Workshops: %d, Dashboard: %b",
                employeeCount, workshopsPerMonth, onlineDashboard);
    }
}