package ncu.edu.cn.bbs.dao;


import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class ArticleDto {
        private List<Article> articles;
        private List<Question> questions;
        private boolean showPrevious;
        private boolean showFirstPage;
        private boolean showNext;
        private boolean showEndPage;
        private Integer page;
        private List<Integer> pages = new ArrayList<>();  //显示的页码
        private Integer totalPage;

        public void setPagination(Integer totalPage, Integer page) {
            this.totalPage = totalPage;
            this.page = page;

            pages.add(page);
            for (int i = 1; i <= 2; i++) {
                if (page - i > 0)
                    pages.add(0, page - i);

                if (page + i <= totalPage)
                    pages.add(page + i);
            }

            // 是否展示上一页
            if (page == 1) showPrevious = false;
            else showPrevious = true;


            // 是否展示下一页
            if (page == totalPage) showNext = false;
            else showNext = true;


            // 是否展示第一页
            if (pages.contains(1)) showFirstPage = false;
            else showFirstPage = true;

            // 是否展示最后一页
            if (pages.contains(totalPage)) showEndPage = false;
            else showEndPage = true;

        }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
