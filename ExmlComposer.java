package XMLhandler;

import parser.XLScell;

import java.util.ArrayList;
import java.util.Map;

import static XMLhandler.NumberOfSchemaReport.J0147105;
import static XMLhandler.NumberOfSchemaReport.J1312002;

public final class ExmlComposer {
    /**
     * Fulfills all actions with making up XML document
     */
    private ExmlComposer() {

    }


    /**
     * @param storageInMemory
     * @return
     */


    static private XMLTAG makePart_DECLAREHEAD(StorageInMemory storageInMemory) {
        ArrayList<XMLTAG> listOfTAGs = new ArrayList<>();

        String[] tagNamesOfHeadElemens = storageInMemory.getHeadNameStrings();
        for (String tagName : tagNamesOfHeadElemens) {
            if (storageInMemory.hasSuchTagConstantParameter(tagName)) {
                listOfTAGs.add(new XMLSimpleTAG(tagName, storageInMemory.getConstantParameterForTAGByName(tagName)));
            } else {
                listOfTAGs.add(new XMLSimpleTAG(tagName, new XMLSimpleText(storageInMemory.getHeaderElement(tagName))));
            }
        }

        XMLTAG[] arrayOfTags = new XMLTAG[listOfTAGs.size()];
        int i = 0;
        for (XMLTAG xmltag : listOfTAGs) {
            arrayOfTags[i++] = xmltag;
        }
        return new XMLSimpleTAG(storageInMemory.getHeadPartName(), arrayOfTags);
    }

    static private XMLTAG makePart_DECLARBODY(StorageInMemory storageInMemory) {
        ArrayList<XMLTAG> listOfTAGs = new ArrayList<>();

        /**
         *
         *  At first filled constant strings, such as <b>HSTI, HTIN, HNAME</b>
         */
        String[] tagNamesOfFooter01 = storageInMemory.getFooterNameStrings1();
        for (String tagName : tagNamesOfFooter01) {
            listOfTAGs.add(new XMLSimpleTAG(tagName, new XMLSimpleText(storageInMemory.getFooterElement1(tagName))));

        }

        int rowsAmount = storageInMemory.getHowMuchRowsInBodyTable();

        XMLLABELelementType[] arrayOfXMLElementsTypeInTables = XMLLABELelementTypeInTableJ1312002.values();

        XLScell[][] scellsMatrix = new XLScell[arrayOfXMLElementsTypeInTables.length][rowsAmount];

        /**
         *
         *  here memory allocation for matrix
         */
        for (XMLLABELelementType typeInTable : arrayOfXMLElementsTypeInTables) {
            typeInTable.getCode();
            scellsMatrix[typeInTable.getCode()] = new XLScell[rowsAmount];
        }


        /**
         *
         *  Get transposition matrix of elements here :
         */
        for (XMLLABELelementType typeInTable : arrayOfXMLElementsTypeInTables) {
            for (int i = 0; i < rowsAmount; i++) {
                scellsMatrix[typeInTable.getCode()][i] = storageInMemory.getOneCellOfBodyTable(i, typeInTable.getCode());
            }
        }
        /**
         *
         *
         *  Here store transposed matrix in <b>ArrayList</b> of TAGs  <i>listOfTAGs</i>
         */
        for (XMLLABELelementType typeInTable : arrayOfXMLElementsTypeInTables) {
            for (int i = 0; i < rowsAmount; i++) {

                String addingValue;

                if (!scellsMatrix[typeInTable.getCode()][i].isEmpty()) {
                    addingValue = scellsMatrix[typeInTable.getCode()][i].getCellValue();
                } else {
                    addingValue = " ";
                }
                XMLTAG tag;
                if (addingValue != null && !addingValue.isEmpty()) {
                    tag = new XMLSimpleTAG(typeInTable.toString(), new XMLSimpleText(addingValue), new XMLSimpleParameter("ROWNUM", "" + (i + 1)));
                } else {
                    tag = new XMLSimpleTAG(typeInTable.toString(), new XMLSimpleParameter("ROWNUM", "" + (i + 1)));
                }
                if (storageInMemory.hasSuchTagConstantParameter(typeInTable.toString())) {
                    ((XMLSimpleTAG) tag).addNewParameter(new XMLSimpleParameter("xsi:nil", "true"));
                }
                listOfTAGs.add(tag);
            }
        }

        /**
         *
         *  At the end, just before closing TAG <b>DECLAREBODY</b> fill constant strings, such as <b>HBOSS, HFILL</b>
         */

        String[] tagNamesOfFooter02 = storageInMemory.getFooterNameStrings2();
        for (String tagName : tagNamesOfFooter02) {
            listOfTAGs.add(new XMLSimpleTAG(tagName, new XMLSimpleText(storageInMemory.getFooterElement2(tagName))));
        }


        XMLTAG[] arrayOfTags = new XMLTAG[listOfTAGs.size()];
        int i = 0;
        for (XMLTAG xmltag : listOfTAGs) {
            arrayOfTags[i++] = xmltag;
        }
        XMLTAG returnedTAG = new XMLSimpleTAG(storageInMemory.getBodyPartName(), arrayOfTags);
        return returnedTAG;
    }

    static public DECLAR make_all_document(NumberOfSchemaReport numberOfSchemaReport, StorageInMemory storageInMemory) {
        XMLTAG TAG_DECLAREHEAD;
        XMLTAG TAG_DECLARBODY;
        XMLTAG[] arryOfTAGs;

        XMLTAG TAG_root;


        TAG_DECLAREHEAD = makePart_DECLAREHEAD(storageInMemory);
        TAG_DECLARBODY = makePart_DECLARBODY(storageInMemory);

        arryOfTAGs = new XMLSimpleTAG[2];
        arryOfTAGs[0] = TAG_DECLAREHEAD;
        arryOfTAGs[1] = TAG_DECLARBODY;
        TAG_root = new XMLSimpleTAG("DECLAR", arryOfTAGs);

        if (numberOfSchemaReport == NumberOfSchemaReport.J1312002) {

            return new DECLAR(J1312002, TAG_root);
        } else if (numberOfSchemaReport == J0147105) {

            return new DECLAR(J0147105, TAG_root);
        }
        return null;
    }

    static public void writeDocumentIntoXMLFile(DECLAR xmlDocument) {
        if (xmlDocument != null) {
            xmlDocument.setEncodingString("windows-1251");
            /**
             *
             *  Here should be block for making file name for XML file to be written
             *
             * @// TODO: 25.02.2020
             * for a while I use temporary file name
             */
            //xmlDocument.setXMLFileName("proba");

            xmlDocument.prepareDocument();

            xmlDocument.writeDocument();

        }

    }

    static public DECLAR composeXMLFileName(DECLAR xmlDocument, StorageInMemory storageInMemory) {
        Map<String, String> headers = storageInMemory.getHeadElements();

        String fileName = DECLAR.makingFileName(headers);

        xmlDocument.setXMLFileName(fileName);

        return xmlDocument;
    }

}
