package XMLhandler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;


public class DECLAR {

    private final NumberOfSchemaReport _numberOfSchema;
    Document document;
    DocumentBuilder builder;
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private String xmlFileName;
    private String xmlDirectory;
    private String encodingString;
    private String xmlns_xsi__Value;
    private String xsi__Value;
    private String xmlns_xsi__Name;
    private String xsi__Name;
    private XMLTAG xmlRootTAG;


    public DECLAR() {
        xmlns_xsi__Name = "xmlns:xsi";
        xmlns_xsi__Value = "http://www.w3.org/2001/XMLSchema-instance";
        xsi__Name = "xsi:noNamespaceSchemaLocation";
        _numberOfSchema = NumberOfSchemaReport.noschema;
    }


    public DECLAR(NumberOfSchemaReport numberOfSchema) {

        xmlns_xsi__Name = "xmlns:xsi";
        xmlns_xsi__Value = "http://www.w3.org/2001/XMLSchema-instance";
        xsi__Name = "xsi:noNamespaceSchemaLocation";

        if (numberOfSchema == NumberOfSchemaReport.J1312002) { // та схема, что я делал в февр. & марте 2020
            xsi__Value = "=\"J1312002.XSD\"";
        } else if (numberOfSchema == NumberOfSchemaReport.J0147105) {
            xsi__Value = "=\"J0147105.XSD\"";
        }
        _numberOfSchema = numberOfSchema;
        if (_numberOfSchema != NumberOfSchemaReport.noschema) {
            XMLTAGParameter[] xmltagParameters = new XMLTAGParameter[10];
            xmltagParameters[0] = new XMLSimpleParameter(xmlns_xsi__Name, xmlns_xsi__Value);
            xmltagParameters[1] = new XMLSimpleParameter(xsi__Name, xsi__Value);
            xmlRootTAG = new XMLSimpleTAG("DECLAR", xmltagParameters);
        }
    }


    public DECLAR(NumberOfSchemaReport numberOfSchema, XMLTAG rootTag) {
        xmlns_xsi__Name = "xmlns:xsi";
        xmlns_xsi__Value = "http://www.w3.org/2001/XMLSchema-instance";
        xsi__Name = "xsi:noNamespaceSchemaLocation";

        switch (numberOfSchema) {
            case J1312002: // та схема, что я делал в февр. & марте 2020
                xsi__Value = "=\"J1312002.XSD\"";
                break;
            case J0147105:
                xsi__Value = "=\"J0147105.XSD\"";
                break;
            default:
        }

        _numberOfSchema = numberOfSchema;
        if (_numberOfSchema != NumberOfSchemaReport.noschema) {
            XMLTAGParameter[] xmltagParameters = new XMLTAGParameter[10];
            xmltagParameters[0] = new XMLSimpleParameter(xmlns_xsi__Name, xmlns_xsi__Value);
            xmltagParameters[1] = new XMLSimpleParameter(xsi__Name, xsi__Value);
            xmlRootTAG = new XMLSimpleTAG("DECLAR", xmltagParameters);
        }


        XMLTAGParameter[] xmltagParameters = new XMLTAGParameter[10];
        xmlns_xsi__Name = "xmlns:xsi";
        xmlns_xsi__Value = "http://www.w3.org/2001/XMLSchema-instance";
        xmltagParameters[0] = new XMLSimpleParameter(xmlns_xsi__Name, xmlns_xsi__Value);
        xsi__Name = "xsi:noNamespaceSchemaLocation";

        switch (numberOfSchema) {
            case J1312002: // та схема, что я делал в февр. & марте 2020
                xsi__Value = "J1312002.xsd"; // J1312002.XSD  J1212002.XSD
                break;
            case J0147105:
                xsi__Value = "J0147105.XSD"; //
                break;
            default:
        }

        xmltagParameters[1] = new XMLSimpleParameter(xsi__Name, xsi__Value);

        //XMLSimpleTAG

        String strOfClassName = rootTag.getClass().getName();

        boolean isStringEqual = strOfClassName.matches(".*XMLSimpleTAG.*");

        if (isStringEqual) {
            XMLSimpleTAG tag = (XMLSimpleTAG) rootTag;
            tag.addNewParameter(xmltagParameters[0]);
            tag.addNewParameter(xmltagParameters[1]);
            xmlRootTAG = rootTag;
        } else {
            xmlRootTAG = new XMLSimpleTAG("DECLAR", xmltagParameters);
        }
    }

    static public String makingFileName(Map<String, String> inboundMap) {
        String[] arrayOfOrderOfStrings = {"C_REG", "C_RAJ", "TIN", "C_DOC", "C_DOC_SUB", "C_DOC_VER", "C_DOC_STAN", "C_DOC_TYPE", "C_DOC_CNT", "PERIOD_TYPE", "PERIOD_MONTH", "PERIOD_YEAR", "C_STI_ORIG"};


        StringBuilder stringOfFileName = new StringBuilder();
        for (String oneKey : arrayOfOrderOfStrings) {

            switch (oneKey) {
                case "C_DOC":
                case "C_DOC_SUB":
                case "C_DOC_STAN":
                case "PERIOD_TYPE":
                case "PERIOD_YEAR":
                case "C_STI_ORIG":
                case "C_REG":
                case "C_RAJ":
                    stringOfFileName.append(inboundMap.get(oneKey));
                    break;
                case "TIN":
                    if (Formatter4XML.isStringDigit(inboundMap.get(oneKey))) {
                        stringOfFileName.append(Formatter4XML.customFormatDigitsWithZeros("0000000000", inboundMap.get(oneKey)));
                    }
                    break;
                case "PERIOD_MONTH":
                case "C_DOC_VER":
                case "C_DOC_TYPE":
                    if (Formatter4XML.isStringDigit(inboundMap.get(oneKey))) {
                        stringOfFileName.append(Formatter4XML.customFormatDigitsWithZeros("00", inboundMap.get(oneKey)));
                    }
                    break;
                case "C_DOC_CNT":
                    if (Formatter4XML.isStringDigit(inboundMap.get(oneKey))) {
                        stringOfFileName.append(Formatter4XML.customFormatDigitsWithZeros("0000000", inboundMap.get(oneKey)));
                    }
                    break;
                default:
            }
        }
        return stringOfFileName.toString();
    }

    public void setXMLDirectory(String dir) {
        xmlDirectory = dir;
    }

    public void setXMLFileName(String fileName) {
        xmlFileName = fileName + ".xml";
    }

    public void setEncodingString(String encodingPage) {
        encodingString = encodingPage;
    }

    public boolean prepareDocument() {

        XMLTAG currTAG = xmlRootTAG;

        if (factory == null) {
            factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
        }

        try {

            if (builder == null) {
                builder = factory.newDocumentBuilder();
            }
            document = builder.newDocument();
            document.appendChild(traverseTAGsTree(currTAG));
            document.setXmlVersion("1.0");
            // System.out.println("Debug only");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        //this.document =
        return false;
    }

    public boolean writeDocument() {
        boolean resultOfOperation = false;


        Transformer transformer = null;
        DOMSource domSource = null;
        FileOutputStream fos = null;

        try {
            if (document != null) {
                System.out.println("-----");
                document.setXmlStandalone(true);
                transformer = TransformerFactory.newInstance().newTransformer();
                domSource = new DOMSource(document);
                fos = new FileOutputStream(this.xmlDirectory + xmlFileName);

                StreamResult result = new StreamResult(fos);
                transformer.setOutputProperty("encoding", "windows-1251");
                transformer.transform(domSource, result);
                System.out.println("-----");


                resultOfOperation = true;

            }
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
            resultOfOperation = false;
        } finally {
            return resultOfOperation;
        }
    }

    private Element traverseTAGsTree(XMLTAG inputTAG) {

        if (inputTAG.getClass().getSimpleName().equals("XMLSimpleTAG")) {
            XMLSimpleTAG xmlSimpleTAG = (XMLSimpleTAG) inputTAG;
            Element addingXMLelement = document.createElement(xmlSimpleTAG.getName());
            if (xmlSimpleTAG.getName().equals("DECLAR")) {
                addingXMLelement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
                        "xsi:noNamespaceSchemaLocation",
                        "J1312002.XSD");
            } //here, we are setting out Name space for XML document

            if (xmlSimpleTAG.isRecursive()) {
                XMLElement dirtyContent = xmlSimpleTAG.getContent();
                if (dirtyContent.getClass().getSimpleName().equals("XMLTAGs")) {
                    XMLTAGs collectionTAGs = (XMLTAGs) dirtyContent;
                    for (XMLTAG oneTag : collectionTAGs) {
                        if (oneTag != null) {
                            addingXMLelement.appendChild(traverseTAGsTree(oneTag));
                        }
                    }
                }
            } else {
                if (xmlSimpleTAG.haveTextContent) {
                    Text textNode = document.createTextNode(xmlSimpleTAG.getTextValue());
                    addingXMLelement.appendChild(textNode);
                }
            }
            if (xmlSimpleTAG.haveIAnyParameters()) {   // adding now parameters to just created Element
                String[] arrayOfParameterNames = (xmlSimpleTAG.getAllParameterNames());
                for (String oneParameterName : arrayOfParameterNames) {
                    addingXMLelement.setAttribute(oneParameterName, (xmlSimpleTAG.getParamValueAsString(oneParameterName)));
                }
            }
            return addingXMLelement;
        }
        return null;
    }

}
