package many_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ans123")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String ansname;
	private String postedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnsname() {
		return ansname;
	}
	public void setAnsname(String ansname) {
		this.ansname = ansname;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
}
