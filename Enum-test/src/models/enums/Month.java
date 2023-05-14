package models.enums;

public enum Month {
    JANEIRO(1, 200),
    FEVEREIRO(2, 00),
    MARCO(3, 400),
    ABRIL(4, 400),
    MAIO(5, 400),
    JUNHO(6, 300),
    JULHO(7, 300),
    AGOSTO(8, 300),
    SETEMBRO(9, 300),
    OUTUBRO(10, 300),
    NOVEMBRO(11, 300),
    DEZEMBRO(12, 300);

    private final int id;
    private final double value;

    private Month(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        var monthName = this.name();
        return monthName.substring(0, 1).toUpperCase()
                + monthName.substring(1).toLowerCase();
    }

    public double getSpentMoney()
            throws IllegalArgumentException {

        return get(id).value;
    }

    public static Month get(int monthId) {
        if (isInvalidMonthId(monthId)) {
            throw new IllegalArgumentException("models.enums.Month id must be between 1 and 12");
        }

        monthId--;
        return values()[monthId];
    }

    private static boolean isInvalidMonthId(int monthId) {
        return monthId < 1 || monthId > 12;
    }
}
