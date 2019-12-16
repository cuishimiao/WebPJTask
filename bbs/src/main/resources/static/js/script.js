// DOM 加载完再执行
$(function () {

    $(document).on('click', '#message-size-btn', function () {
        $.ajax({
            url: "/messages/recentNotRead",
            type: "get",
            dataType: 'json',
            success: function (data) {
                console.log(data.body);
                var content = '<ul class="menu">';
                var count = 0;
                $.each(data.body, function (i, item) {
                    content +=
                        '<li>' +
                        '<a href="' + '/manage/messages?uid=' + item.uid + '" target="_blank">' +
                        '<div class="pull-left">' +
                        '<img class="img-circle" src="' + item.avatar + '" alt="头像">' +
                        '</div>' +
                        '<h4>' + item.name +
                        '<small><span class="text-maroon">' + item.count + '条未读</span> <i class="fa fa-clock-o"></i> ' + item.createTime + '</small>' +
                        '</h4>' +
                        '<p class="nowrap">' + item.content + '</p>' +
                        '</a>' +
                        '</li>';
                    count += item.count;
                });
                content += '</ul>';
                $("#not-read-message-list").html(content);
            },
            error: function () {
            }
        });
    });

    $(document).on('click', '#notice-size-btn', function () {
        $.ajax({
            url: "/notice/recentNotRead",
            type: "get",
            dataType: 'json',
            success: function (data) {
                var content = '<ul class="menu">';
                var count = 0;
                $.each(data.body, function (i, item) {
                    content +=
                        '<li>' +
                        '<a href="/manage/notices" target="_blank">' +
                        '<i class="' + item.style + '"></i>' +
                        item.count + " 条" + item.content +
                        '</a>' +
                        '</li>';
                    count += item.count;
                });
                content += '</ul>';
                $("#not-read-notice-list").html(content);
                $(".notice-size").html(count);

            },
            error: function () {
            }
        })
    });

    //登录提交
    $(document).on("click", "#login_btn", function () {
        var param={
            username:$("#username").val(),
            password:$("#password").val()
        };

        $.ajax({
            url: "/login",
            type: 'POST',
            contentType:"application/json",
            data: JSON.stringify(param),
            success: function (data) {
                if(typeof (data["msg"])=="string"){
                    $("#message").html(data["msg"]);
                }
                else{
                    var content = '<ul class="nav navbar-nav" id="user-nav">'+
                        '<li class="dropdown user user-menu" id="user-menu">'+
                        '<img src="../images/logn.png" width="25" height="25" class="user-image">'+
                        '<span class="hidden-xs">'+data["msg"].username+'</span>'+'</li></ul>'
                    $("#login").modal("hide");
                }$("#user-nav-wrapper").html(content);

            }
        });
        return false;
    });

    // 加载推荐文章
    $(document).ready(function () {
        $.ajax({
            url: "/articles",
            type: 'GET',
            dataType:"json",
            success: function (msg) {
                var obj = msg;
                var content='<div class="profile-mine__content mb0">';
                for(var i in obj ){
                    content+=
                        '<li>'+
                        '<div class="row">'+
                        '<div class="col-md-12 profile-mine__content--title-warp">'+
                        '<p class="nowrap bold" style="font-size:16px;">'+
                        '<a class="link-primary" target="_blank" href=/getArticle/'+obj[i].article_id+'>'+obj[i].title+'</a>'+
                        '</p>'+
                        '<ul class="list-inline" style="font-size: 12px!important;line-height: 30px;">'+
                        '<li>'+
                        '<a href="#" target="_blank">'+
                        '<img src="/static/images/head.jpeg" alt="" class="img-circle" width="30" height="30">'+
                        '<span>'+obj[i].uname+'</span>'+'</a>'+
                        '</li>'+
                        '<li class="pull-right">'+
                        '<a href="#" class="link-black" target="_blank">'+
                        '<i class="margin-r-5"></i>'+'评论(5)'+'</a>'+
                        '</li>'+
                        '<li class="pull-right">'+
                        '<a href="#" class="link-black" target="_blank">'+
                        '<i class="margin-r-5"></i>'+'阅读(123)'+'</a>'+
                        '</li>'+
                        '<li>'+
                        '<a href="#" class="link-black disabled">'+
                        '<i class="margin-r-5"></i>'+obj[i].create_time+'</a>'+
                        '</li>'+
                        '</ul>'+
                        '</div>'+
                        '</div>'+
                        '</li>'
                }
                $("#box-body").html(content)
            }
        });
    });
});

