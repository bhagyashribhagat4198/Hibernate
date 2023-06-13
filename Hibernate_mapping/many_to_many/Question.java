package many_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="que123")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String que_name;
	
	@ManyToMany(targetEntity=Answer.class,cascade={CascadeType.ALL})
	@JoinTable(name="que_ans",
	joinColumns={@JoinColumn(name="q_id")},
	inverseJoinColumns={@JoinColumn(name="ans_id")})
	private List<Answer> answer;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQue_name() {
		return que_name;
	}
	public void setQue_name(String que_name) {
		this.que_name = que_name;
	}
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}	
}
