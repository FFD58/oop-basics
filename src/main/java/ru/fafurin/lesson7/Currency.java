package ru.fafurin.lesson7;

public enum Currency {
    USD ("R01235", "US Dollar"),
    EUR ("R01239", "Euro"),
    GBP ("R01035", "Pound Sterling of the United Kingdom"),
    DEM ("R01510", "German brand");

    private final String id;
    private final String title;

    Currency(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
