package org.apache.cayenne.testdo.relationships_child_master.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.testdo.relationships_child_master.Child;

/**
 * Class _Master was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Master extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<String> NAME = new Property<>("name");
    public static final Property<List<Child>> CHILDREN = new Property<>("children");

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void addToChildren(Child obj) {
        addToManyTarget("children", obj, true);
    }
    public void removeFromChildren(Child obj) {
        removeToManyTarget("children", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Child> getChildren() {
        return (List<Child>)readProperty("children");
    }


}
