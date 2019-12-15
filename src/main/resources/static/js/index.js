$(function () {

// 获取文章列表
    function getArticleList(pageIndex) {
        $.ajax({
            url: '/',
            type: 'GET',
            data: {
                "async": true,
                "pageIndex": pageIndex
            },
            success: function (data) {
                $("#article-box").html(data);
            },
            error: function () {
                layer.msg("后台好像偷了点小懒哦，重新刷新一下试试！", {icon: 2});
            }
        });
    }


    //分页获取评论列表
    $(document).on('click', '.page-link', function () {
        if ($(this).hasClass('current')) {
            return false;
        }
        var pageIndex = $(this).attr("pageIndex");
        getArticleList(pageIndex);
    });


//跳转到指定的页号
    $(document).on('keydown', '.jump-page-size', function (event) {
        var max = parseInt($(this).attr("max"));
        var pageIndex = parseInt($(this).val());
        if (event.keyCode === "13") {//keyCode=13是回车键
            if (pageIndex === "" || pageIndex == null) {
                return false;
            }
            if (!/^\d+$/.test(pageIndex)) {
                pageIndex = 1;
            }
            if (pageIndex < 1) {
                pageIndex = 1;
            }
            if (pageIndex > max) {
                pageIndex = max;
            }
            getArticleList(pageIndex);
        }
    });

    $(document).on('click', '#my-article-a', function () {

        var username = $("meta[name='_username']").attr("content");
        if (username == null) {
            $("#").click();
            return false;
        } else {
            window.location.href = "/" + username;
        }
    });

    $(document).on("click",".ranking-list-item-more",function () {
        $(".ranking-list-item").removeClass("hide");
        $(".ranking-list-item-more").hide();
    });
});