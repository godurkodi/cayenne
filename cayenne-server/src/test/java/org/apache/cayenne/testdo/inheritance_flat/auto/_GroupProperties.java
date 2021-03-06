package org.apache.cayenne.testdo.inheritance_flat.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.testdo.inheritance_flat.Group;

/**
 * Class _GroupProperties was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _GroupProperties extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> DESCRIPTION = new Property<>("description");
    public static final Property<Long> ID = new Property<>("id");
    public static final Property<Group> GROUP = new Property<>("group");

    public void setDescription(String description) {
        writeProperty("description", description);
    }
    public String getDescription() {
        return (String)readProperty("description");
    }

    public void setId(Long id) {
        writeProperty("id", id);
    }
    public Long getId() {
        return (Long)readProperty("id");
    }

    public void setGroup(Group group) {
        setToOneTarget("group", group, true);
    }

    public Group getGroup() {
        return (Group)readProperty("group");
    }


}
