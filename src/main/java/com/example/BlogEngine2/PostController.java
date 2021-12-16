package com.example.BlogEngine2;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
        this.postService = postService;
    }
	
	@GetMapping(value = { "", "/" })
    public @NotNull Iterable<Post> getPost() {
        return postService.getAllPost();
    }
	
    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String createPost(Post post) {
        postService.save(post);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/pTc", method = RequestMethod.POST)
    public String pTc(Post post, Category ctgry) {
        postService.PostToCategory(post, ctgry);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/pFc", method = RequestMethod.POST)
    public String pFc(Post post, Category ctgry) {
        postService.PostFromCategory(post, ctgry);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
    public String editPostWithId(Long id, Model model) {
    	Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(Long id) {
        Post post = postService.getPost(id);
        postService.delete(post);
        return "redirect:/";
    }
}
