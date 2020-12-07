import XMLhandler.XMLLABELelementType;

public enum TAGConstant implements XMLLABELelementType {
    HEAD,
    BODY,
    BEFORETABLE,
    AFTERTABLE,
    TIN,
    C_DOC,
    C_DOC_SUB,
    C_DOC_VER,
    C_DOC_TYPE,
    C_DOC_CNT,
    C_REG,
    C_RAJ,
    PERIOD_MONTH,
    PERIOD_TYPE,
    PERIOD_YEAR,
    C_STI_ORIG,
    C_DOC_STAN,
    LINKED_DOCS,
    DOC,
    FILENAME,
    D_FILL,
    SOFTWARE,
    HSTI,
    HTIN,
    HNAME,
    HBOS,
    HFILL,
    HZ,
    HNUM,
    HZY,
    R00G1,
    R01G1S,
    R01G2S,
    R01G3S,
    R01G4S,
    R01G5S,
    R03G1S,
    R03G2S,
    R03G3S,
    R03G4S,
    R04G1S,
    R04G2S,
    R04G3S,
    R04G4S,
    R01G20;

    @Override
    public int compareTo(XMLLABELelementType el) {

        if (el == null || !el.getClass().getName().contains("TAGConstant")) {
            return -1;
        } else {
            TAGConstant cmpelmnt = (TAGConstant) el;
            return this.toString().compareTo(cmpelmnt.toString());
        }
    }

    @Override
    public int getCode() {
        return super.hashCode();
    }
}

