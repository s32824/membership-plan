public class GymMembershipPlan extends MembershipPlan implements Freezable {
    private int entriesPerMonth;
    private boolean saunaAccess;

    //constructor
    public GymMembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int entriesPerMonth, boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.entriesPerMonth = entriesPerMonth;
        this.saunaAccess = saunaAccess;
    }

    @Override
    public String getPlanType() {
        return "Gym Membership";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();
        price += (entriesPerMonth * 4);

        if (saunaAccess) {
            price += 25.0;
        }

        if (isAutoRenew()) {
            price -= 10.0;
        }

        return price;
    }

    @Override
    public boolean canFreeze() {
        //IF duration is at least 3 months
        return getMonths() >= 3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Entries: %d, Sauna: %b", entriesPerMonth, saunaAccess);
    }
}