public abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    //constructor
    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    //abstract methods
    public abstract String getPlanType();

    //also in the Billable interface
    public abstract double calculateMonthlyNetPrice();

    //implemented methods
    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * 1.23;
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    //final summary method
    public final void printSummary() {
        System.out.println("Plan type: " + getPlanType());
        System.out.println("Plan code: " + planCode);
        System.out.println("Client: " + clientName);
        System.out.println("Monthly net price: " + calculateMonthlyNetPrice());
        System.out.println("Monthly gross price: " + calculateMonthlyGrossPrice());
        System.out.println("Total contract net value: " + calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return String.format("Plan: %s [%s], Client: %s, Duration: %d months, Auto-renew: %b", getPlanType(), planCode, clientName, months, autoRenew);
    }

    //getters
    protected double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    protected boolean isAutoRenew() {
        return autoRenew;
    }

    protected int getMonths() {
        return months;
    }

    protected String getClientName() {
        return clientName;
    }
}