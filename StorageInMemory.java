package XMLhandler;

import parser.XLScell;
import parser.XLSrow;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static XMLhandler.NumberOfSchemaReport.J0147105;
import static XMLhandler.NumberOfSchemaReport.J1312002;

public class StorageInMemory {

    private static final String[] stringTAGs4Header = {"TIN", "C_DOC", "C_DOC_SUB", "C_DOC_VER", "C_DOC_TYPE",
            "C_DOC_CNT", "C_REG", "C_RAJ", "PERIOD_MONTH", "PERIOD_TYPE", "PERIOD_YEAR",
            "C_STI_ORIG", "C_DOC_STAN", "LINKED_DOCS", "D_FILL", "SOFTWARE"};
    private static final String[] stringTAGs4Header__LINKED_DOCS = {"C_DOC", "C_DOC_SUB", "C_DOC_VER", "C_DOC_TYPE",
            "C_DOC_CNT", "C_DOC_STAN", "FILENAME"};
    private static final String[] stringTAGs4Body1 = {"HSTI", "HTIN", "HNAME"};
    private static final String[] stringTAGs4Body1SchemaJ0147105 = {"HZ", "HNUM", "HZY"};
    private static final String[] stringTAGs4Body1ListSchemaJ0147105 = {"R00G1", "R01G1S", "R01G2S",
            "R01G3S", "R01G4S", "R01G5S", "R03G1S", "R03G2S", "R03G3S", "R03G4S", "R04G1S", "R04G2S", "R04G3S", "R04G4S"};
    private static final String[] stringTAGsBody2SchemaJ0147105 = {"R01G20"};
    private static final String[] stringTAGsBody2 = {"HBOS", "HFILL"};
    private int howMuchRows;
    private Locale local;
    private String headPartName;
    private String bodyPartName;
    private NumberOfSchemaReport _numberOfSchemaReport;
    private Map<String, String> headElements;
    private Map<String, String> headElements__LINKED_DOCS; // inserted here double tags :
    // <LINKED_DOCS><DOC ..> all tags from this map </DOC></LINKED_DOCS>
    private Map<Integer, XLSrow> rowsOfBodyTable;
    private Map<String, String> bodyElements1;
    private Map<String, String> bodyElements2;
    private Map<String, XMLTAGParameter> tagsWithParameters;


    public StorageInMemory(NumberOfSchemaReport numberOfSchemaReport) {
        init(numberOfSchemaReport);
    }

    public StorageInMemory(NumberOfSchemaReport numberOfSchemaReport, Map<String, String> inboundHeadElements) {
        init(numberOfSchemaReport);

        overlayHeadElements(inboundHeadElements);

    }

    public StorageInMemory(NumberOfSchemaReport numberOfSchemaReport, Map<String, String> inboundHeadElements, Map<String, String> inboundBodyElements1, Map<String, String> inboundBodyElements2) {
        init(numberOfSchemaReport);

        overlayHeadElements(inboundHeadElements);

        overlayBodyElements1(inboundBodyElements1);

        overlayBodyElements2(inboundBodyElements2);
    }


    private void init(NumberOfSchemaReport _numberOfSchemaReport) {
        local = new Locale("uk", "ua");

        this._numberOfSchemaReport = _numberOfSchemaReport;

        howMuchRows = 0;
        headPartName = "DECLARHEAD";
        bodyPartName = "DECLARBODY";
        headElements = new LinkedHashMap<String, String>();
        headElements__LINKED_DOCS = new LinkedHashMap<String, String>();
        rowsOfBodyTable = new LinkedHashMap<Integer, XLSrow>();
        bodyElements1 = new LinkedHashMap<String, String>();
        bodyElements2 = new LinkedHashMap<String, String>();
        tagsWithParameters = new LinkedHashMap<String, XMLTAGParameter>();

        {

            String[] stringValues = {"05747991", "J13", "120", "2", "0", "1", "18", "19",
                    "1", "1", "2020", "1819", "1", "", "09012020", "MEDOC"};
            int i = 0;
            for (String sTAGname : stringTAGs4Header) {
                headElements.put(sTAGname, stringValues[i++]);
            }
        }

        if (this._numberOfSchemaReport == J1312002) {


            {
                String[] stringValues = {"ГОЛОВНЕ УПРАВЛІННЯ ДПС У СУМСЬКІЙ ОБЛАСТІ, УПРАВЛІННЯ У М.СУМАХ  (М. СУМИ)",
                        "05747991", "Акціонерне товариство \"Сумське машинобудівне науково-виробниче об'єднання\""};
                int i = 0;
                for (String sTAGname : stringTAGs4Body1) {
                    bodyElements1.put(sTAGname, stringValues[i++]);
                }
            }
        } else if (this._numberOfSchemaReport == J0147105) {

        } else { // noschema

        }


        {
            String[] stringValues = {"Лук`яненко Володимир Матвійович", "09012020"};
            int i = 0;
            for (String sTAGname : stringTAGsBody2) {
                bodyElements2.put(sTAGname, stringValues[i++]);
            }
        }

        String[] tagNamesWhichHaveParameters = {
                "LINKED_DOCS",
                "DOC",
                "T1RXXXXG4S",
                "T1RXXXXG11",
                "T1RXXXXG12S"
        };
        XMLTAGParameter simpleParameter = new XMLSimpleParameter("xsi:nil", "true");
        for (String tagName : tagNamesWhichHaveParameters) {
            tagsWithParameters.put(tagName, simpleParameter);
        }

    }

    private int overlayHeadElements(Map<String, String> inboundHeadElements) {
        int i = 0;
        for (String sTAGname : stringTAGs4Header) {
            String stringToBeAssigned = inboundHeadElements.get(sTAGname);
            if (stringToBeAssigned != null && !stringToBeAssigned.isEmpty()) {
                if (headElements.containsKey(sTAGname)) {
                    String oldStringValue = headElements.get(sTAGname);
                    if (!oldStringValue.equals(stringToBeAssigned)) {
                        headElements.remove(sTAGname, oldStringValue);
                        headElements.put(sTAGname, stringToBeAssigned);
                        i++;
                    }
                } else {
                    headElements.put(sTAGname, stringToBeAssigned);
                    i++;
                }
            }
        }
        return i;
    }

    private int overlayBodyElements1(Map<String, String> inboundBodyElements1) {
        int i = 0;
        for (String sTAGname : stringTAGs4Body1) {
            String stringToBeAssigned = inboundBodyElements1.get(sTAGname);
            if (stringToBeAssigned != null && !stringToBeAssigned.isEmpty()) {
                if (bodyElements1.containsKey(sTAGname)) {
                    String oldStringValue = bodyElements1.get(sTAGname);
                    if (!oldStringValue.equals(stringToBeAssigned)) {
                        bodyElements1.remove(sTAGname, oldStringValue);
                        bodyElements1.put(sTAGname, stringToBeAssigned);
                        i++;
                    }
                } else {
                    bodyElements1.put(sTAGname, stringToBeAssigned);
                    i++;
                }
            }
        }
        return i;
    }

    private int overlayBodyElements2(Map<String, String> inboundBodyElements2) {
        int i = 0;
        for (String sTAGname : stringTAGsBody2) {
            String stringToBeAssigned = inboundBodyElements2.get(sTAGname);
            if (stringToBeAssigned != null && !stringToBeAssigned.isEmpty()) {
                if (bodyElements2.containsKey(sTAGname)) {
                    String oldStringValue = bodyElements2.get(sTAGname);
                    if (!oldStringValue.equals(stringToBeAssigned)) {
                        bodyElements2.remove(sTAGname, oldStringValue);
                        bodyElements2.put(sTAGname, stringToBeAssigned);
                        i++;
                    }
                } else {
                    bodyElements2.put(sTAGname, stringToBeAssigned);
                    i++;
                }
            }
        }
        return i;
    }


    public String getHeadPartName() {
        return this.headPartName;
    }

    public String getBodyPartName() {
        return this.bodyPartName;
    }

    public String[] getHeadNameStrings() {

        return stringTAGs4Header;
    }

    public int getHowMuchHeadElements() {
        return headElements.size();
    }

    public String[] getFooterNameStrings1() {

        return stringTAGs4Body1;
    }

    public String[] getFooterNameStrings2() {

        return stringTAGsBody2;
    }

    public int getHowMuchFooterElements1() {
        return bodyElements1.size();
    }

    public int getHowMuchFooterElements2() {
        return bodyElements2.size();
    }

    public boolean storeHeaderElement(String key, String value) {

        String valueString;

        if (this.headElements.containsKey(key)) {
            valueString = this.headElements.get(key);
            if (valueString.equals(value)) {
                return true;
            } else {
                this.headElements.remove(key);
                this.headElements.put(key, value);
                return true;
            }
        } else {
            this.headElements.put(key, value);
            return true;
        }
    }

    public boolean storeFooterElement2(String key, String value) {

        String valueString;

        if (this.bodyElements2.containsKey(key)) {
            valueString = this.bodyElements2.get(key);
            if (valueString.equals(value)) {
                return true;
            } else {
                this.bodyElements2.remove(key);
                this.bodyElements2.put(key, value);
                return true;
            }
        } else {
            this.bodyElements2.put(key, value);
            return true;
        }
    }

    public boolean isExistHeaderElement(String key) {

        return this.headElements.containsKey(key);
    }

    public boolean isExistFooterElement1(String key) {

        return this.bodyElements1.containsKey(key);
    }

    public boolean isExistFooterElement2(String key) {

        return this.bodyElements2.containsKey(key);
    }

    public String getHeaderElement(String key) {

        if (this.headElements.containsKey(key))
            return this.headElements.get(key);
        return "";
    }

    public String getFooterElement1(String key) {

        if (this.bodyElements1.containsKey(key))
            return this.bodyElements1.get(key);
        return "";
    }

    public String getFooterElement2(String key) {

        if (this.bodyElements2.containsKey(key))
            return this.bodyElements2.get(key);
        return "";
    }

    public boolean storeBodyTableElement(Integer indexRow, XMLLABELelementTypeInTableJ1312002 key, String value) {

        boolean resultOfRowAdding = false;

        XLSrow newRow, foundOldRow;

        XLScell cell = new XLScell();
        cell.setCellKey(key);
        cell.setCellValue(value);


        if (this.rowsOfBodyTable.containsKey(indexRow)) {
            foundOldRow = this.rowsOfBodyTable.get(indexRow);
            if (foundOldRow.contains(key)) {
                XLScell foundCell = foundOldRow.getCell(key);
                if (!cell.equals(foundCell)) {
                    foundCell.setCellValue(value);
                }
                resultOfRowAdding = true;
            } else {
                resultOfRowAdding = foundOldRow.add(cell);
            }
        } else {
            newRow = new XLSrow(indexRow);
            cell = new XLScell();

            resultOfRowAdding = newRow.add(cell);
        }
        if (resultOfRowAdding) {
            this.howMuchRows++;
        }
        return resultOfRowAdding;
    }

    public boolean storeBodyTableElement(Integer indexRow, XLSrow xlsRow) {
        if (xlsRow == null) return false;

        boolean result = false;
        XLSrow foundRow;

        if (this.rowsOfBodyTable.containsKey(indexRow)) {
            foundRow = this.rowsOfBodyTable.get(indexRow);
            if (foundRow.equals(xlsRow)) {
                result = true;
            } else {     // if there is such indexRow, we replace old one by new one
                this.rowsOfBodyTable.remove(indexRow, xlsRow);
                rowsOfBodyTable.put(indexRow, xlsRow);
                if (this.rowsOfBodyTable.containsKey(indexRow)) {
                    result = true;
                }
            }
        } else {
            rowsOfBodyTable.put(indexRow, xlsRow);
            if (this.rowsOfBodyTable.containsKey(indexRow)) {
                result = true;
            }
        }
        return result;
    }

    public int getHowMuchRowsInBodyTable() {
        int howMuchRowsInBodyTable = 0;
        if (rowsOfBodyTable != null && !rowsOfBodyTable.isEmpty()) {
            howMuchRowsInBodyTable = rowsOfBodyTable.size();
        }
        return howMuchRowsInBodyTable;
    }

    public int getHowMuchColumnsInBodyTable() {

        return rowsOfBodyTable.get(1).size();
    }

    public XLScell getOneCellOfBodyTable(int numRow, int numCol) {
        XLScell[] oneRow = (XLScell[]) rowsOfBodyTable.get(numRow).toArray();

        return oneRow[numCol];
    }

    public XLScell getOneCellOfBodyTable(int numRow, XMLLABELelementTypeInTableJ1312002 column) {
        XLSrow oneRow = rowsOfBodyTable.get(numRow);

        return oneRow.getCell(column);
    }

    public String getBodyTableElement(Integer indexRow, XMLLABELelementTypeInTableJ1312002 key) {

        if (this.rowsOfBodyTable.containsKey(indexRow)) {
            XLSrow row = this.rowsOfBodyTable.get(indexRow);
            if (row.contains(key)) {
                return row.getStringValue(key);
            }
        }
        return "";
    }

    public boolean isSuchRowStoredInTable(int iRow) {
        Integer integerRow = iRow;

        return this.rowsOfBodyTable.containsKey(integerRow);
    }

    public boolean hasSuchTagConstantParameter(String tagName) {
        return tagsWithParameters.containsKey(tagName);
    }

    public XMLTAGParameter getConstantParameterForTAGByName(String tagName) {
        return tagsWithParameters.get(tagName);
    }

    public Map<String, String> getHeadElements() {
        Map<String, String> returnedMap = new LinkedHashMap<String, String>();
        for (String sTAGname : stringTAGs4Header) {
            returnedMap.put(sTAGname, headElements.get(sTAGname));
        }
        return returnedMap;
    }

    public void setHeadElements(Map<String, String> inboundHeadElements) {
        headElements = inboundHeadElements;
    }

    public Map<String, String> getBodyElements1() {
        Map<String, String> returnedMap = new LinkedHashMap<String, String>();
        for (String sTAGname : stringTAGs4Body1) {
            returnedMap.put(sTAGname, bodyElements1.get(sTAGname));
        }
        return returnedMap;
    }


    public Map<String, String> getBodyElements2() {
        Map<String, String> returnedMap = new LinkedHashMap<String, String>();
        for (String sTAGname : stringTAGsBody2) {
            returnedMap.put(sTAGname, bodyElements2.get(sTAGname));
        }
        return returnedMap;
    }

}
