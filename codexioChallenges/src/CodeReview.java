import java.util.ArrayList;
import java.util.List;

public class CodeReview {
    public static void main(String[] args) {
        Shop shop = Shop.getInstance();
        SalesConsultant consultant1 = new SalesConsultant();
        SalesConsultant consultant2 = new SalesConsultant();
        MarketingSpecialist specialist1 = new MarketingSpecialist();
        MarketingSpecialist specialist2 = new MarketingSpecialist();

        consultant1.sellProduct(1000.0);
        consultant2.sellProduct(1500.0);
        specialist1.spendMoney(2000.0);
        specialist2.spendMoney(1000.0);

        double shopTurnover = shop.getTurnover();
        double specialistBudget = specialist1.getBudget();

        System.out.println("Total Shop Turnover: $" + shopTurnover);
        System.out.println("Marketing Specialist 1 Budget: $" + specialistBudget);
    }

    static class Shop {
        private static Shop instance;
        private List<Object> workers = new ArrayList<>();

        private Shop() {
        }

        public static Shop getInstance() {
            if (instance == null) {
                instance = new Shop();
            }
            return instance;
        }

        public void addWorker(Object worker) {
            this.workers.add(worker);
        }

        public double getTurnover() {
            double turnover = 0.0;
            for (Object worker : this.workers) {
                if (worker instanceof SalesConsultant) {
                    turnover += ((SalesConsultant) worker).getMoney();
                } else if (worker instanceof MarketingSpecialist) {
                    turnover -= ((MarketingSpecialist) worker).getBudget();
                }
            }
            return turnover;
        }
    }

    static class SalesConsultant {
        private Shop workingShop;
        private double earnedMoney;

        public SalesConsultant() {
            this.workingShop = Shop.getInstance();
            this.workingShop.addWorker(this);
        }

        public void sellProduct(double price) {
            this.earnedMoney += Math.max(price, 0);
        }

        public double getMoney() {
            return this.earnedMoney;
        }
    }

    static class MarketingSpecialist {
        private Shop workingShop;
        private double budget = 5000.00;

        public MarketingSpecialist() {
            this.workingShop = Shop.getInstance();
            this.workingShop.addWorker(this);
        }

        public void spendMoney(double marketingCampaignCost) {
            this.budget -= Math.max(marketingCampaignCost, 0);
        }

        public double getBudget() {
            return this.budget;
        }
    }
}
