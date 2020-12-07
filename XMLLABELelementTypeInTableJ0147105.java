package XMLhandler;

public enum XMLLABELelementTypeInTableJ0147105 implements XMLLABELelementType {
    T1RXXXXG2S,
    T1RXXXXG3S,
    T1RXXXXG4S,
    T1RXXXXG5S,
    T1RXXXXG6S,
    T1RXXXXG7D,
    T1RXXXXG8S,
    T1RXXXXG9S,
    T1RXXXXG10S,
    T1RXXXXG11S,
    T1RXXXXG12S,
    T1RXXXXG13S,
    T1RXXXXG14D,
    T1RXXXXG15D,
    T1RXXXXG16,
    T1RXXXXG17,
    T1RXXXXG18S,
    T1RXXXXG19S,
    T1RXXXXG20,
    T1RXXXXG21S,
    T1RXXXXG22S,
    T1RXXXXG23,
    T1RXXXXG24,
    T1RXXXXG25;

    @Override
    public int compareTo(XMLLABELelementType el) {
        if (el == null || !el.getClass().getName().contains("XMLLABELelementTypeInTableJ0147105")) {
            return -1;
        } else {
            XMLLABELelementTypeInTableJ0147105 cmpelmnt = (XMLLABELelementTypeInTableJ0147105) el;
            return this.toString().compareTo(cmpelmnt.toString());
        }
    }

    @Override
    public int getCode() {

        switch (this) {
            case T1RXXXXG2S:
                return 0;
            case T1RXXXXG3S:
                return 1;
            case T1RXXXXG4S:
                return 2;
            case T1RXXXXG5S:
                return 3;
            case T1RXXXXG6S:
                return 4;
            case T1RXXXXG7D:
                return 5;
            case T1RXXXXG8S:
                return 6;
            case T1RXXXXG9S:
                return 7;
            case T1RXXXXG10S:
                return 8;
            case T1RXXXXG11S:
                return 9;
            case T1RXXXXG12S:
                return 10;
            case T1RXXXXG13S:
                return 11;
            case T1RXXXXG14D:
                return 12;
            case T1RXXXXG15D:
                return 13;
            case T1RXXXXG16:
                return 14;
            case T1RXXXXG17:
                return 15;
            case T1RXXXXG18S:
                return 16;
            case T1RXXXXG19S:
                return 17;
            case T1RXXXXG20:
                return 18;
            case T1RXXXXG21S:
                return 19;
            case T1RXXXXG22S:
                return 20;
            case T1RXXXXG23:
                return 21;
            case T1RXXXXG24:
                return 22;
            case T1RXXXXG25:
                return 23;
        }
        return 0;
    }


}
