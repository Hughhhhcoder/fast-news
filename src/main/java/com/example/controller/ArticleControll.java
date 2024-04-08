package com.example.controller;

import com.example.pojo.Article;
import com.example.pojo.Category;
import com.example.pojo.Result;
import com.example.service.ArticleService;
import org.apache.ibatis.annotations.Delete;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.pojo.PageBean;

@RestController
@RequestMapping("/article")
public class ArticleControll {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pb = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pb);

    }


    @PutMapping
    public Result update(@RequestBody Article article){
        articleService.update(article);
        return Result.success();

    }

    @GetMapping("/detail")
    public Result<Article> detail(Integer id){
        Article a= articleService.findById(id);
        return Result.success(a);

    }

    @DeleteMapping
    public Result<String> delete(Integer id){
        articleService.delete(id);
        return Result.success("删除成功");
    }


}
