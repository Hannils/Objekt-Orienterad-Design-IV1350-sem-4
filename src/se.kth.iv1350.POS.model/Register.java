package src.se.kth.iv1350.POS.model;

    /**
     * Virtual register used for keeping track of the money.
     */
    public class Register {
        double amount;

        /**
         * This function specifies the amount in the register.
         */
        private Register(){
            this.amount = 1000;
        }

        /**
         * Gets and returns the amount in the register
         * @return double the amount of money in the register (double)
         */
        public double getAmount(){
            return amount;
        }

        /**
         * Updates the amount in the register
         * @param amount the relative change of the amount.
         */
        public void updateAmount(double amount){
            this.amount += amount;
        }

        private static class RegisterHolder {
            private static Register instance = new Register();
        }

        /**
         * This is the function which returns the instance of the Register.
         * @return The instance of the register.
         */
        public static Register getInstance() {
            return RegisterHolder.instance;
        }
    }
