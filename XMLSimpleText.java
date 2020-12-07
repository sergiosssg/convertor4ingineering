package XMLhandler;

public class XMLSimpleText implements XMLContent {

    private final String textValue;

    public XMLSimpleText() {
        textValue = "";
    }

    public XMLSimpleText(String txt) {
        textValue = txt;
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
        return textValue;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return textValue.isEmpty();
    }

    @Override
    public XMLElement getContent() {
        return this;
    }

    @Override
    public String toString() {
        return textValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().getName().equals("XMLSimpleText")) {
            return false;
        }
        XMLSimpleText otherXMLSimpleText = (XMLSimpleText) obj;
        return textValue.equals(otherXMLSimpleText.textValue);
    }

    @Override
    public int hashCode() {
        return textValue.hashCode();
    }

}
