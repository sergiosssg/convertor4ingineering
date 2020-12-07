package XMLhandler;

public enum XMLLABELelementTypeInTableJ1312002 implements XMLLABELelementType {
    T1RXXXXG2,
    T1RXXXXG3,
    T1RXXXXG4S,
    T1RXXXXG5,
    T1RXXXXG6,
    T1RXXXXG7S,
    T1RXXXXG8S,
    T1RXXXXG9,
    T1RXXXXG10,
    T1RXXXXG11,
    T1RXXXXG12S;

    @Override
    public int compareTo(XMLLABELelementType el) {
        if (el == null || !el.getClass().getName().contains("XMLLABELelementTypeInTableJ1312002")) {
            return -1;
        } else {
            XMLLABELelementTypeInTableJ1312002 cmpelmnt = (XMLLABELelementTypeInTableJ1312002) el;
            return this.toString().compareTo(cmpelmnt.toString());
        }
    }

    @Override
    public int getCode() {

        switch (this) {
            case T1RXXXXG2:
                return 0;
            case T1RXXXXG3:
                return 1;
            case T1RXXXXG4S:
                return 2;
            case T1RXXXXG5:
                return 3;
            case T1RXXXXG6:
                return 4;
            case T1RXXXXG7S:
                return 5;
            case T1RXXXXG8S:
                return 6;
            case T1RXXXXG9:
                return 7;
            case T1RXXXXG10:
                return 8;
            case T1RXXXXG11:
                return 9;
            case T1RXXXXG12S:
                return 10;
        }
        return 0;
    }


}
