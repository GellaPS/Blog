package com.example.BlogEngine2;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "categories")
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ctrgy_id")
    private Long id;
	
	@NotNull(message = "Name is required.")
    @Basic(optional = false)
	@Column(name = "name")
	private String name;
	
	@Column(name = "labels")
    @Length(min = 3, max = 10)
	private List<String> labels;
	
	@OneToMany(mappedBy = "ctgry")
	private List<Post> posts;
	
	public Category(Long id, @NotNull(message = "Name is required.") String name, List<String> labels, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.labels = labels;
        this.posts = posts;
    }
	
	public Category() {
    }
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
