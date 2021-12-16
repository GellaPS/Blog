package com.example.BlogEngine2;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private PostRepository postRepo;
	
	@Autowired
	public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }
	
	public Iterable<Post> getAllPost() {
        return postRepo.findAll();
    }
	
	public Post getPost(long id) {
        return postRepo.findById(id).get();
    }
	
	 public void delete(Post post) {
		 postRepo.delete(post);
	 }
	
	public void save(Post post) {
		post.setDateModified(LocalDate.now());
		postRepo.save(post);
	}
	
	public Post create(Post post) {
		post.setDateAdded(LocalDate.now());
        return this.postRepo.save(post);
    }
	
	public void PostToCategory(Post post, Category ctgry) {
		post.addCtgry(ctgry);;
		postRepo.save(post);
    }
	
	public void PostFromCategory(Post post, Category ctgry) {
		post.removeCtgry(ctgry);;
		postRepo.save(post);
    }

}
