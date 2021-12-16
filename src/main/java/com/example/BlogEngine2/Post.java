package com.example.BlogEngine2;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "posts")
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
    private Long id;
	
	@NotNull(message = "Title is required.")
    @Basic(optional = false)
	@Column(name = "title")
    private String title;
	
	@NotNull(message = "Text is required.")
    @Basic(optional = false)
	@Column(name = "text")
    private String text;
	
	@Column(name = "dateAdded", nullable = false, updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dateAdded;
	
	@Column(name = "dateModified", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dateModified;
	
	@ManyToOne
    @JoinColumn(name = "ctgry", referencedColumnName = "ctrgy_id")
    @NotNull
	private List<Category> ctgry;
	
	public Post(Long id, @NotNull(message = "Title is required.") String title, @NotNull(message = "Text is required.") String text, LocalDate dateAdded, LocalDate dateModified, List<Category> ctgry) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.ctgry = ctgry;
    }
	
	public Post() {
    }
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
    
    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }
    
    public List<Category> getCtgry() {
        return ctgry;
    }

    public void setCtgry(List<Category> ctgry) {
        this.ctgry = ctgry;
    }
    
    public void addCtgry(Category ctgry) {
    	if (this.ctgry.size() < 5)
    		this.ctgry.add(ctgry);
    }
    
    public void removeCtgry(Category ctgry) {
    	if (this.ctgry.size() > 1)
    		this.ctgry.remove(ctgry);
    }

}
