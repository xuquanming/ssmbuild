package com.company.controller;


import com.company.pojo.Books;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面

    @RequestMapping("/allBook")
    public String list(Model model){

        List<Books> list = bookService.queryAllBook();
        System.out.println(list.toString());
        model.addAttribute("list",list);

        return "allBook";

    }

    //跳转到增加书籍页面

    @RequestMapping("/toAddBook")
    public String toAddPage(Model model){



        return "addBook";

    }

    //添加书籍的请求

    @RequestMapping("/addBooks")
    public String addBook(Books books){


        System.out.println("addBook==>"+books.toString());

        bookService.addBook(books);
        return "redirect:/book/allBook";

    }


    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String addUpdatePage(int id,Model model){

        Books books = bookService.queryBookById(id);
        model.addAttribute("books",books);
        return "updateBook";

    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){


        System.out.println("updateBook==>"+books.toString());
        bookService.updateBook(books);
        return "redirect:/book/allBook";

    }


    //修改书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){



        bookService.deleteBookById(id);
        return "redirect:/book/allBook";

    }

    //查询书籍
    @RequestMapping("/queryBookByName")
    public String queryBook(String queryBookName,Model model){


        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if(books==null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";

    }



}
