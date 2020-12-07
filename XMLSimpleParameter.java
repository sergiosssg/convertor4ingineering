package XMLhandler;

public class XMLSimpleParameter implements XMLContent, XMLTAGParameter {
    private String parameterName;
    private XMLSimpleText parameterValue;


    public XMLSimpleParameter() {
        parameterName = "";
        parameterValue = new XMLSimpleText();
    }

    public XMLSimpleParameter(String name) {
        parameterName = name;
        parameterValue = new XMLSimpleText();
    }

    public XMLSimpleParameter(String name, String value) {
        parameterName = name;
        parameterValue = new XMLSimpleText(value);
    }

    public XMLSimpleParameter(String name, XMLContent value) {
        parameterName = name;
        if (value != null && value.getClass().getName().equals("XMLSimpleText")) {
            parameterValue = (XMLSimpleText) value;
        } else {
            parameterValue = new XMLSimpleText();
        }
    }

    @Override
    public boolean isEmpty() {
        return parameterName.isEmpty() || parameterValue.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().getName().equals("XMLSimpleParameter")) {
            return false;
        }
        XMLSimpleParameter xmlSimpleParameter = (XMLSimpleParameter) obj;
        return parameterName.equals(xmlSimpleParameter.parameterName) &&
                parameterValue.equals(xmlSimpleParameter.parameterValue);
    }

    @Override
    public int hashCode() {
        return parameterName.hashCode() + parameterValue.hashCode();
    }

    @Override
    public boolean isRecursive() {
        return false;
    }

    @Override
    public boolean isTextValue() {
        return true;
    }

    @Override
    public String getTextValue() {
        return parameterValue.getTextValue();
    }

    public void setTextValue(String value) {
        parameterValue = new XMLSimpleText(value);
    }

    @Override
    public String getName() {
        return parameterName;
    }

    @Override
    public void setName(String name) {
        parameterName = name;
    }

    @Override
    public XMLElement getValue() {
        return parameterValue;
    }

    @Override
    public void setValue(XMLElement value) {
        String name = value.getName();
        String stringValue = value.toString();
        if (parameterName.isEmpty() && !name.isEmpty()) {
            parameterName = name;
        }

    }

    @Override
    public XMLContent getContent() {
        return parameterValue;
    }

    @Override
    public boolean isValueAText() {
        return true;
    }
}
