package pl.allegro.tech.hermes.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Group {

    @NotNull
    private String groupName;

    /**
     * To be removed after migration to topics' owner field
     */
    @Deprecated
    private String supportTeam;

    @JsonCreator
    public Group(@JsonProperty("groupName") String groupName,
                 @JsonProperty("supportTeam") String supportTeam
    ) {
        this.groupName = groupName;
        this.supportTeam = supportTeam;
    }

    public static Group from(String groupName) {
        return new Group(groupName, null);
    }

    public String getGroupName() {
        return groupName;
    }

    @Deprecated
    public String getSupportTeam() {
        return supportTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Group)) {
            return false;
        }
        Group group = (Group) o;

        return Objects.equals(this.getGroupName(), group.getGroupName())
                && Objects.equals(this.getSupportTeam(), group.getSupportTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, supportTeam);
    }

    @Override
    public String toString() {
        return "Group(" + groupName + ")";
    }
}
