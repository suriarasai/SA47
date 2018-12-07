
package edu.iss.cats.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CourseEvent class
 *
 * @version $Revision: 1.0
 */
@Entity
public class CourseEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseeventid")
	private int courseEventId;
	@Temporal(TemporalType.DATE)
	@Column(name = "timestamp")
	private Date timeStamp;
	@Column(name = "eventtype")
	private String eventType;
	@Column(name = "eventby")
	private String eventBy;
	@Column(name = "comment")
	private String comment;
	// Reverse Relation
	@ManyToOne
	@JoinColumn(name = "courseid")
	private Course course;

	public CourseEvent() {
	}

	public CourseEvent(int courseEventId, Date timeStamp, String eventType, String eventBy, String comment,
			Course course) {
		super();
		this.courseEventId = courseEventId;
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.eventBy = eventBy;
		this.comment = comment;
		this.course = course;
	}

	public int getCourseEventId() {
		return courseEventId;
	}

	public void setCourseEventId(int courseEventId) {
		this.courseEventId = courseEventId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventBy() {
		return eventBy;
	}

	public void setEventBy(String eventBy) {
		this.eventBy = eventBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseEventId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseEvent other = (CourseEvent) obj;
		if (courseEventId != other.courseEventId)
			return false;
		return true;
	}

	
}