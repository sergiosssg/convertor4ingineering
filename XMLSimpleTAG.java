package XMLhandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class XMLSimpleTAG implements XMLTAG {
    private final String tagName;
    private final Map<String, XMLTAGParameter> mapOfParameters;
    boolean haveTextContent;
    private XMLTAG parent;
    private boolean iAmEmpty;
    private XMLElement tagContent;

    public XMLSimpleTAG() {
        parent = null;
        iAmEmpty = true;
        mapOfParameters = new LinkedHashMap<>();
        tagName = null;
        tagContent = null;
        haveTextContent = false;
    }

    /*
    public XMLSimpleTAG(String name){
        parent = null;
        tagName = name;
        iAmEmpty = true;
        mapOfParameters = new LinkedHashMap<>();
        tagContent = null;
        haveTextContent = false;
    } */


    /*
    public XMLSimpleTAG(XMLTAG parent, String name){
        this.parent = parent;
        tagName = name;
        iAmEmpty = true;
        mapOfParameters = new LinkedHashMap<>();
        tagContent = null;
        haveTextContent = false;
    }*/


    /**
     * @param name    tag name
     * @param content text content of this tag
     */
    public XMLSimpleTAG(String name, XMLSimpleText content) {
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        tagContent = content;
        iAmEmpty = false;
        haveTextContent = true;
    }

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLSimpleText content){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        tagContent = content;
        iAmEmpty = false;
        haveTextContent = true;
    } */

    /**
     * @param name      tag name
     * @param parameter one parameter of this tag
     */
    public XMLSimpleTAG(String name, XMLTAGParameter parameter) {
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);
        tagContent = null;
        iAmEmpty = true;
        haveTextContent = false;
    }

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAGParameter parameter){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);
        tagContent = null;
        iAmEmpty = true;
        haveTextContent = false;
    }*/

    /**
     * @param name       tag name
     * @param parameters array of parameters
     */
    public XMLSimpleTAG(String name, XMLTAGParameter[] parameters) {
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for (XMLTAGParameter oneParameter : parameters) {
            if (oneParameter != null) {
                mapOfParameters.put(oneParameter.getName(), oneParameter);
            }
        }
        tagContent = null;
        iAmEmpty = true;
        haveTextContent = false;
    }

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAGParameter[] parameters){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for(XMLTAGParameter oneParameter : parameters){
            mapOfParameters.put(oneParameter.getName(), oneParameter);
        }
        tagContent = null;
        iAmEmpty = true;
        haveTextContent = false;
    } */


    /*
    public XMLSimpleTAG(String name, XMLTAG child){
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        XMLTAGs childrenTAGs = new XMLTAGs(this, child);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAG child){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        XMLTAGs childrenTAGs = new XMLTAGs(this, child);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /**
     * @param name     tag name
     * @param children array of children tag
     */
    public XMLSimpleTAG(String name, XMLTAG[] children) {
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        XMLTAGs childrenTAGs = new XMLTAGs(this, children);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    }

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAG[] children){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        XMLTAGs childrenTAGs = new XMLTAGs(this, children);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(String name, XMLTAGParameter parameter,XMLTAG child){
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);
        XMLTAGs childrenTAGs = new XMLTAGs(this, child);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAGParameter parameter, XMLTAG child){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);
        XMLTAGs childrenTAGs = new XMLTAGs(this, child);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(String name, XMLTAGParameter parameter,XMLTAG[] children){
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);
        XMLTAGs childrenTAGs = new XMLTAGs(this, children);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAGParameter parameter, XMLTAG[] children){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);
        XMLTAGs childrenTAGs = new XMLTAGs(this, children);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(String name, XMLTAGParameter[] parameters, XMLTAG child){
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for(XMLTAGParameter oneParameter : parameters){
            mapOfParameters.put(oneParameter.getName(), oneParameter);
        }
        XMLTAGs childrenTAGs = new XMLTAGs(this, child);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAGParameter[] parameters, XMLTAG child){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for(XMLTAGParameter oneParameter : parameters){
            mapOfParameters.put(oneParameter.getName(), oneParameter);
        }
        XMLTAGs childrenTAGs = new XMLTAGs(this, child);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(String name, XMLTAGParameter[] parameters, XMLTAG[] children){
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for(XMLTAGParameter oneParameter : parameters){
            mapOfParameters.put(oneParameter.getName(), oneParameter);
        }
        XMLTAGs childrenTAGs = new XMLTAGs(this, children);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /*
    public XMLSimpleTAG(XMLTAG parent, String name, XMLTAGParameter[] parameters, XMLTAG[] children){
        this.parent = parent;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for(XMLTAGParameter oneParameter : parameters){
            mapOfParameters.put(oneParameter.getName(), oneParameter);
        }
        XMLTAGs childrenTAGs = new XMLTAGs(this, children);
        tagContent = childrenTAGs;
        iAmEmpty = false;
        haveTextContent = false;
    } */

    /**
     * @param name       tag name
     * @param tagContent text tag content
     * @param parameter  one parameter of this tag
     */
    public XMLSimpleTAG(String name, XMLSimpleText tagContent, XMLTAGParameter parameter) {
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        mapOfParameters.put(parameter.getName(), parameter);

        this.tagContent = tagContent;
        iAmEmpty = false;
        haveTextContent = true;
    }

    /**
     * @param name       tag name
     * @param tagContent text tag content
     * @param parameters array of parameters for this tag
     */
    public XMLSimpleTAG(String name, XMLSimpleText tagContent, XMLTAGParameter[] parameters) {
        parent = null;
        tagName = name;
        mapOfParameters = new LinkedHashMap<>();
        for (XMLTAGParameter oneParameter : parameters) {
            if (oneParameter != null) {
                mapOfParameters.put(oneParameter.getName(), oneParameter);
            }
        }
        this.tagContent = tagContent;
        iAmEmpty = false;
        haveTextContent = true;
    }


    @Override
    public String getName() {
        return tagName;
    }

    @Override
    public boolean isEmpty() {
        return iAmEmpty;
    }

    @Override
    public XMLElement getContent() {
        return tagContent;
    }

    public boolean haveITextContent() {
        return haveTextContent;
    }

    public boolean haveIAnyParameters() {
        return !mapOfParameters.isEmpty();
    }

    @Override
    public boolean isRecursive() {
        return !isEmpty() && (
                tagContent.getClass().getSimpleName().equals("XMLSimpleTAG") ||
                        tagContent.getClass().getSimpleName().equals("XMLTAGs") ||
                        tagContent.getClass().getSimpleName().equals("XMLTAG"));
    }

    @Override
    public boolean isTextValue() {
        return tagContent.getClass().getName().equals("XMLSimpleText");
    }

    @Override
    public String getTextValue() {
        return tagContent.toString();
    }

    public boolean isExistSuchParameter(String paramName) {
        return mapOfParameters.containsKey(paramName);
    }

    public String[] getAllParameterNames() {
        Set<String> set = mapOfParameters.keySet();
        //Object[] arrayOfObject = set.toArray();

        return set.toArray(new String[set.size()]);
    }

    public String getParamValueAsString(String name) {
        if (mapOfParameters.containsKey(name)) {
            return mapOfParameters.get(name).getValue().toString();
        }
        return null;
    }

    @Override
    public XMLTAG getParent() {
        return parent;
    }

    @Override
    public void setParent(XMLTAG tag) {
        this.parent = tag;
    }

    @Override
    public int howMuchChildrenIHave() {
        if (this.isRecursive() && tagContent.getClass().getName().equals("XMLTAGs")) {
            XMLTAGs childrenTAG = (XMLTAGs) tagContent;
            return childrenTAG.howMuchChildrenIHave();
        }
        return 0;
    }

    public int howMuchParametersIHave() {
        return mapOfParameters.size();
    }


    public String[] getAllChildrenNames() {
        if (this.isRecursive() && tagContent.getClass().getName().equals("XMLTAGs")) {
            XMLTAGs childrenTAGs = (XMLTAGs) tagContent;
            return childrenTAGs.getChildrenNames();
        }
        return null;
    }

    @Override
    public XMLTAG getChildByName(String name) {

        if (this.hasSuchTagByName(name)) {
            XMLTAGs childrenTAGs = (XMLTAGs) tagContent;
            return childrenTAGs.getChildByName(name);
        }
        return null;
    }


    @Override
    public boolean hasSuchTagByName(String name) {
        if (tagContent.getClass().getName().equals("XMLTAGs")) {
            XMLTAGs childrenTAGs = (XMLTAGs) tagContent;
            return childrenTAGs.hasSuchTagByName(name);
        }
        return false;
    }

    @Override
    public void addNewTag(XMLTAG tag) {
        if (tag.getParent().getName().equals(tagName)) {
            tag.setParent(tag);
        }
        if (this.tagContent.isEmpty() || this.haveITextContent() || !this.tagContent.getClass().getName().equals("XMLTAGs")) {
            tagContent = new XMLTAGs(this, tag);

            this.haveTextContent = false;
            this.iAmEmpty = false;
        } else if (tagContent.getClass().getName().equals("XMLTAGs")) {
            XMLTAGs xmltaGs = (XMLTAGs) tagContent;
            xmltaGs.addNewTag(tag);

            this.haveTextContent = false;
            this.iAmEmpty = false;
        }
    }

    public boolean addNewParameter(XMLTAGParameter param) {

        String paramName = param.getName();
        if (!mapOfParameters.isEmpty()) {
            if (mapOfParameters.containsKey(paramName)) {
                mapOfParameters.remove(paramName);
                mapOfParameters.put(paramName, param);
                return true;
            } else {
                mapOfParameters.put(paramName, param);
                return true;
            }
        }
        return false;
    }
}
