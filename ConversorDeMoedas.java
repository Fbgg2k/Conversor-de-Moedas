import javax.swing.JOptionPane;

public class ConversorDeMoedas {
    public static void main(String[] args) {
        String[] currencyOptions = {
            "Reais",
            "Dólar",
            "Euro",
            "Libras Esterlinas"
        };

        int fromCurrencyChoice = JOptionPane.showOptionDialog(
            null,
            "Selecione a moeda de origem",
            "Conversor de Moedas",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            currencyOptions,
            currencyOptions[0]
        );

        int toCurrencyChoice = JOptionPane.showOptionDialog(
            null,
            "Selecione a moeda de destino",
            "Conversor de Moedas",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            currencyOptions,
            currencyOptions[1]
        );

        double amount = getAmountFromUser("Digite o valor em " + currencyOptions[fromCurrencyChoice] + ":");

        double convertedAmount = convertCurrency(amount, fromCurrencyChoice, toCurrencyChoice);
        showMessage("Valor convertido: " + convertedAmount + " " + currencyOptions[toCurrencyChoice]);
    }

    private static double getAmountFromUser(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            showMessage("Valor inválido. Tente novamente.");
            return getAmountFromUser(message);
        }
    }

    private static double convertCurrency(double amount, int fromCurrencyChoice, int toCurrencyChoice) {
        double[] exchangeRates = { 1.0, 0.188, 0.116, 0.141 }; // Taxas de câmbio corrigidas
        double fromRate = exchangeRates[fromCurrencyChoice];
        double toRate = exchangeRates[toCurrencyChoice];

        return amount * (toRate / fromRate);
    }

    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}

