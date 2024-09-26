public class ResultDisplay {
    private String displayString;

    public ResultDisplay() {
        updateDisplay(0);
    }

    public void updateDisplay(double result) {
        displayString = "Result: " + result;
    }

    public String getDisplay() {
        return displayString;
    }
}
