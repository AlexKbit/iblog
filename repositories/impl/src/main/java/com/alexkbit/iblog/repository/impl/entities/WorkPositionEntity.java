package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity of work position
 */
@Entity
@Table(name = "work_position")
public class WorkPositionEntity extends TimeMarkEntity {


    /**
     * Resume
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="wp_resume")
    private ResumeEntity resume;

    /**
     * Name of company
     */
    @Column(name = "wp_company_name")
    private String companyName;

    /**
     * Name of position
     */
    @Column(name = "wp_position_name")
    private String positionName;

    /**
     * Description
     */
    @Column(name = "wp_description")
    private String description;

    /**
     * Date of start work
     */
    @Column(name = "wp_start_work")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    /**
     * Date of end work
     */
    @Column(name = "wp_end_work")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    /**
     * Work at the current time
     */
    @Column(name = "wp_until_now")
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

    public ResumeEntity getResume() {
        return resume;
    }

    public void setResume(ResumeEntity resume) {
        this.resume = resume;
    }
}
