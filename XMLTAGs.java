package XMLhandler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class XMLTAGs implements XMLTAG, Iterable<XMLTAG> {

    private final List<String> childrenTagNames;
    //private Map<String, XMLTAG> childrenTAGs;
    private final List<XMLTAG> childrenTags;
    private XMLTAG parent;

    public XMLTAGs(XMLTAG parent, XMLTAG child) {
        this.parent = parent;
        childrenTagNames = new LinkedList<>();
        childrenTags = new LinkedList<>();
        childrenTagNames.add(child.getName());
        childrenTags.add(child);
    }


    public XMLTAGs(XMLTAG parent, XMLTAG[] children) {
        this.parent = parent;
        childrenTagNames = new LinkedList<>();
        childrenTags = new LinkedList<>();
        for (XMLTAG child : children) {
            child.setParent(parent);
            String nameOfTag = child.getName();
            childrenTagNames.add(nameOfTag);
            childrenTags.add(child);
        }
    }

    /**
     * @return Name of parent TAG
     */
    @Override
    public String getName() {
        return "/" + parent.getName();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public XMLElement getContent() {
        return (XMLElement) childrenTags;
    }

    @Override
    public XMLTAG getParent() {
        return parent;
    }

    @Override
    public void setParent(XMLTAG tag) {
        parent = tag;
    }

    @Override
    public int howMuchChildrenIHave() {
        return childrenTags.size();
    }

    @Override
    public XMLTAG getChildByName(String name) {
        if (!childrenTags.isEmpty()) {
            if (childrenTagNames.contains(name)) {
                return childrenTags.get(childrenTagNames.indexOf(name));
            }
        }
        return null;
    }

    @Override
    public boolean hasSuchTagByName(String name) {
        return childrenTags.contains(name);
    }

    @Override
    public boolean isRecursive() {
        return true;
    }

    @Override
    public boolean isTextValue() {
        return false;
    }

    @Override
    public void addNewTag(XMLTAG newTAG) {

        if (newTAG != null && newTAG.getClass().getName().equals("XMLSimpleTAG")) {
            XMLSimpleTAG addingTAG = (XMLSimpleTAG) newTAG;
            addingTAG.setParent(this.parent);
            childrenTagNames.add(newTAG.getName());
            childrenTags.add(addingTAG);
        } else if (newTAG != null && newTAG.getClass().getName().equals("XMLTAGs")) {
            XMLTAGs tags = (XMLTAGs) newTAG;
            XMLTAG[] arrayOfTAGs = new XMLTAG[tags.howMuchChildrenIHave()];
            for (int i = 0; i < tags.howMuchChildrenIHave(); i++) {            // a bit awkward
                arrayOfTAGs[i] = childrenTags.get(i);
            }
            for (XMLTAG nTAG : arrayOfTAGs) {
                if (nTAG != null && nTAG.getClass().getName().equals("XMLSimpleTAG")) {
                    nTAG.setParent(this.parent);
                    childrenTagNames.add(nTAG.getName());
                    childrenTags.add(nTAG);
                }
            }
        }
    }

    @Override
    public String getTextValue() {
        /**
         *
         *
         * @// TODO: 21.02.2020
         */
        return null;
    }

    public String[] getChildrenNames() {
        return (String[]) this.childrenTagNames.toArray();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<XMLTAG> iterator() {
        return new TAGIterator();
    }

    private class TAGIterator<XMLTAG> implements Iterator<XMLTAG> {

        private int currIndex;

        public TAGIterator() {
            currIndex = 0;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currIndex < howMuchChildrenIHave();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public XMLTAG next() {
            Object obj = childrenTags.get(currIndex);
            if (obj != null && (obj.getClass().getSimpleName().equals("XMLSimpleTAG") || obj.getClass().getSimpleName().equals("XMLTAGs") || obj.getClass().getSimpleName().equals("XMLTAG"))) {
                XMLTAG xmltag = (XMLTAG) obj;
                currIndex++;
                return xmltag;
            }
            return null;
        }
    }
}
