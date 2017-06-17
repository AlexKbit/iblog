package com.alexkbit.iblog.model;

import java.util.Date;

/**
 * Model of work position
 */
public class WorkPosition extends TimeMarkModel {

    /**
     * Name of work company
     */
    private String companyName;

    /**
     * Name of position in company
     */
    private String positionName;

    /**
     * Description of position
     */
    private String description;

    /**
     * Date of start work
     */
    private Date start;

    /**
     * Date of end work
     */
    private Date end;

    /**
     * Work at the current time
     */
    private Boolean untilNow;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getUntilNow() {
        return untilNow;
    }

    public void setUntilNow(Boolean untilNow) {
        this.untilNow = untilNow;
    }
}
