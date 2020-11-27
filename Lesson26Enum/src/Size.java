public enum Size {
    VERY_SMALL("XS"), SMALL("S"), AVERAGE("M"),BIG("L"),VERY_BIG("XL"),UNDEFINED("");
    private String abbrev;

     Size(String abbrev) {
        this.abbrev=abbrev;
    }

    public String getAbbrev() {
        return abbrev;
    }


}
